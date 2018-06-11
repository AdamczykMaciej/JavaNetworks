import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
	private ServerSocketChannel ssc = null; // a Socket Channel for our server
	private Selector selector = null; // monitors multiple channels, thanks to that we don't have to use multiple
										// threads for handling multiple channels

	public Server() {
		String host = "localhost";
		int port = 45000;
		try {
			ssc = ServerSocketChannel.open(); // opening a Server Socket Channel
			ssc.socket().bind(new InetSocketAddress(host, port)); // binds the Server Socket Channel to a specific
																	// address and port
			ssc.configureBlocking(false); // configured as non-blocking I/O
			selector = Selector.open(); // creates, opens a selector
			// registering a server socket with a selector, ready for accepting some
			// operations
			SelectionKey sscKey = ssc.register(selector, SelectionKey.OP_ACCEPT);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Server launched. Waiting for handling requests...");
		serviceConnections(); // here we will serve incoming connections
	}

	private void serviceConnections() {
		boolean serverIsRunning = true;

		while (serverIsRunning) {

			try {
				selector.select(); // selector blocks the thread, loop and waits until at least 1 channel is
									// SELECTED
				Set keys = selector.selectedKeys(); // a set of selected keys

				Iterator iter = keys.iterator(); // iterating through the keys
				while (iter.hasNext()) {
					SelectionKey key = (SelectionKey) iter.next(); // gets a key
					iter.remove(); // very important. must be removed - no automated removal
					// otherwise we will handle the same key once more
					// OPERATION TYPES: isAcceptable(), isReadable(), isWriteable()
					if (key.isAcceptable()) { // checks whether the selected key is OP_ACCEPT - accepting an incoming
												// connection, enter if the key is acceptable - ready to accept a new
												// connection

						// getting a channel to communicate with a particular client
						SocketChannel cc = ssc.accept();
						// the call of accept is non - blocking - the selector has
						// already established that there is a client waiting on the
						// server socket channel; the method accept() doesn't block
						// anything;
						// creates a SocketChannel for communication between the server and
						// the client
						cc.configureBlocking(false); // non blocking Socket Channel, because will be registered with
														// selector :), which will monitor everything
						cc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
						// register a Socket Channel with our selector (we have 1),
						// another SELECTION KEY is created
						// enables operations: READ or to WRITE
						continue;
					}
					if (key.isReadable()) {
						// we get the Socket Channel of the Readable key :)
						SocketChannel cc = (SocketChannel) key.channel();
						serviceRequest(cc); // handle the request
						continue;
					}
					if (key.isWritable()) {
						SocketChannel cc = (SocketChannel) key.channel();
						serviceRequest(cc);
						continue;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private static Pattern reqPatt = Pattern.compile(" +", 3); // 3 means flag no. 0, 1, 2, 3, 4
	private static String msg[] = { "Ok", "Invalid request", "Dividing by zero is illegal my friend!" }; // the protocol language
	private static Charset charset = Charset.forName("ISO-8859-2"); // for encoding/ decoding
	private static final int BSIZE = 1024; // specifying the buffer size

	private ByteBuffer bbuf = ByteBuffer.allocate(BSIZE); // allocating the buffer, which is to read the data from
															// channel
	private StringBuffer reqString = new StringBuffer(); // for storing the request

	private void serviceRequest(SocketChannel sc) {
//		if (!sc.isOpen())
//			return; // does not have sense 

		// reading the request
		reqString.setLength(0); // it clears the StringBuffer
		bbuf.clear(); // clear the buffer

		try {
			readLoop: while (true) {
				int n = sc.read(bbuf); // reads a sequence of bytes into the given buffer
				if (n > 0) {
					bbuf.flip();
					CharBuffer cbuf = charset.decode(bbuf); // bytes into characters
					while (cbuf.hasRemaining()) { // checking the characters
						char c = cbuf.get();
						if (c == '\r' || c == '\n')
							break readLoop;
						reqString.append(c); // appending string with characters
					}
				}
			}
			String[] req = reqPatt.split(reqString, 4); // maximum number of output strings of the split method
			String cmd = req[0]; // e.g first word from a request

			if (cmd.equals("bye")) { // the end of the conversation
				writeResp(sc, 0, null);
				sc.close(); // close the channel
				sc.socket().close(); // close the underlying socket
			} else if (cmd.equals("echo")) {
				if (req.length != 2)
					writeResp(sc, 1, null);
				else
					writeResp(sc, 0, req[1]);

			} else if (cmd.equals("calculate")) {
				int result = 0;
				if (req.length != 4) { 
					writeResp(sc, 1, null);
				} else if (req.length == 4) { // otherwise we will have ArrayIndexOutOfBoundException, handling exceptions
					Pattern pattern1 = Pattern.compile("\\d+"); 
					Pattern pattern3 = Pattern.compile("\\d+"); 
					Pattern pattern2 = Pattern.compile("[+/\\-(\\*)]");
					Matcher m1 = pattern1.matcher(req[1]);
					Matcher m2 = pattern3.matcher(req[3]); //checking the correct format of operands
					Matcher sign = pattern2.matcher(req[2]);
		
					if (m1.matches() && m2.matches() && sign.matches()) {
						
						if (req[2].equals("+")) // Checking the second argument
							result = Integer.parseInt(req[1]) + Integer.parseInt(req[3]);

						else if (req[2].equals("-"))
							result = Integer.parseInt(req[1]) - Integer.parseInt(req[3]);
						else if (req[2].equals("*"))
							result = Integer.parseInt(req[1]) * Integer.parseInt(req[3]);
						else if (req[2].equals("/") && !req[3].equals("0"))
							result = Integer.parseInt(req[1]) / Integer.parseInt(req[3]);
						if (req[3].equals("0") && req[2].equals("/"))
							writeResp(sc, 2, null);
						else
							writeResp(sc, 0, result + "");

					} else // user enters e.q. calculate 100 - x, calculate 100 ! 20
						writeResp(sc, 1, null); 
				} else // user enters fewer than 4 words e.g. calculate 100 
					writeResp(sc, 1, null);
			} else // user enters sth different from echo, calculate
				writeResp(sc, 1, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private StringBuffer remsg = new StringBuffer();

	private void writeResp(SocketChannel sc, int rc, String addMsg) throws IOException {
		remsg.setLength(0); // creating a response
		remsg.append(rc);
		remsg.append(' ');
		remsg.append(msg[rc]);
		remsg.append('\n');
		if (addMsg != null) {
			remsg.append(addMsg); // can add some own message
			remsg.append('\n');
		}
		ByteBuffer buf = charset.encode(CharBuffer.wrap(remsg)); // charset into bytes
		sc.write(buf); // write the response back to the client
	}

	public static void main(String[] args) {
		new Server();
	}
}
