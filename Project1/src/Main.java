import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

/**
 * 
 * @author Maciek A program operating in two modes: WRITE and READ. NIO is a bit
 *         more efficient, better scalability than IO, because it is a low level
 *         approach. When used in the WRITE mode this program writes 4 numbers
 *         to a file (ofc we can change it), here "0 1 2 3". We do that by using
 *         the MappedByteBuffer (method "put") and sending our data through a
 *         FileChannel. In the READ mode we write the data from the buffer and
 *         print the sum of all its integers. To do that we use an IntBuffer.
 */
public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		String mode = args[0]; // MODE of our application
		Random rand = new Random(); // if we want to generate a random number
		RandomAccessFile file = new RandomAccessFile("./test/input.txt", "rw"); // it is like an array of bytes
		FileChannel channel = file.getChannel();
		final int bufferSize = 20; // we specify the buffer size.
		// Here our buffer contains 4 ints + a mark = 5 ints
		int iterations = 8;
		MappedByteBuffer buf = channel.map(FileChannel.MapMode.READ_WRITE, 0, bufferSize);
		IntBuffer ibuf = buf.asIntBuffer();
		boolean writer = false, reader=false;

		while (true) {
			if (mode.equalsIgnoreCase("WRITE") && ibuf.get(0) == 0 && iterations>0) { // to prevent overwriting, we can remove it if we
																		// want to be able to overwrite
				// System.out.println("Entering the writing mode ...");
				ibuf.put(1); // the "1" means the "write" mode, it is to prevent from overwriting (accessing
								// "write" twice)
				for (int i = 1; i < 4; i++) { // saving random integers
					ibuf.put(rand.nextInt());
				}
				writer=true;
				ibuf.rewind();
				buf.force();
				channel.close();
				// System.out.println("Writing has been completed.");
				iterations--;
				continue;
			}

			if (mode.equalsIgnoreCase("READ") && ibuf.get(0) == 1 ) {
				// System.out.println("Entering the reading mode ...");
				int sum = 0;
				ibuf.put(0); // "0" means the reading mode, to prevent from overwriting

				for (int i = 1; i < ibuf.limit(); i++) { // calculating the sum
					sum += ibuf.get(i);
				}
				reader=true;
				ibuf.rewind();
				channel.close();
				System.out.println("SUM = " + sum);
				// System.out.println("Reading has been completed.");
				Thread.sleep(1000);
				continue;
			} 
			if(writer=true && reader==true)
				break;
			
		}
		file.close();
	}
}