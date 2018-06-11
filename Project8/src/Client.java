import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class Client {
	public static void main(String[] args) {
		try {
			// we need Security Manager if client/ server are located in different directories
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			IEcho message = (IEcho) Naming.lookup("newRemoteElement");
			String msg = "Love";
			EchoRequest req = new EchoRequest(msg);
			EchoResponse resp = message.echo(req);
			EchoResponse resp2 = message.echo(req);
			System.out.println(resp.getResponse());
			System.out.println(resp == resp2); // returns false :), apart from the fact that looks like it should be the
												// same
			// the references are false, because they are of class RemoteElement_Stub which
			// REPRESENTS remote objects on the client side.
			/*
			 * Calling methods for such a stub object results in passing the call to the
			 * remote object (which this stub represents) and executing the call on the
			 * server JVM. Then the result is passed backwards to the stub and the caller
			 * receives it.
			 * 
			 * Stubs are controlled by the local (client) JVM. Each invocation of the method
			 * get() returns a fresh new stub object representing the same single remote
			 * object
			 */

			IAddition add = (IAddition) Naming.lookup("newRemoteElement");
			int a = 10;
			int b = 20;
			AddRequest request = new AddRequest(a, b);
			AddResponse response = add.add(request);
			System.out.println(response.getResult());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
