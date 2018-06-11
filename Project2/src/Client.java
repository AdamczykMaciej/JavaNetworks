import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	private Socket sock = null;
	private PrintWriter out = null;
	private BufferedReader in = null;

	public Client(String[] req) {
		try {
			String host ="localhost";
			int port = 45000;
			sock = new Socket(host, port); // creates a new socket
			out = new PrintWriter(sock.getOutputStream(), true); // for writing to the server (connected to our)
			in = new BufferedReader(new InputStreamReader(sock.getInputStream())); // for reading from the server, socket (connected to the socket)
			// requests
			
			//from the run configuration
			String request="";
			for(int i=0; i<req.length; i++) {
				if(i==req.length-1) {
					request+=req[i];
					break;
				}
				request+=req[i]+" ";
				System.out.println(request);
			}
			
			makeRequest(request);
			makeRequest("bye"); // for closing the connection (it is done on the server side),
			// it entails the termination of Client thread 
			//test
//			makeRequest("add 2 + 2");
//			makeRequest("add 100 * 2");
//			makeRequest("add 2 / 2");
//			makeRequest("add 2 - 2");
//			makeRequest("echo 123");
//			makeRequest("add 223 + 2");
//			makeRequest("et 223 + 2"); //wrong request
//			makeRequest("echo");
//			makeRequest("bye");
			out.close();
			in.close();
			sock.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean makeRequest(String req) throws IOException {
		System.out.println("Request: " + req);
		out.println(req); // sending a request
		String resp = in.readLine(); // retrieving an answer to the request
		System.out.println(resp); // printing the answer (0 , 1 , 2 ,3 , 4)
		boolean ok = resp.startsWith("0");  // for displaying the result
		if ((req.startsWith("calculate") || req.startsWith("echo")) && ok) {
			System.out.println(in.readLine()); // the further answer (the anticipated result)
		}
		System.out.println("Finished request");
		return ok;
	}

	public static void main(String[] args) {
		new Client(args);
	}
}
