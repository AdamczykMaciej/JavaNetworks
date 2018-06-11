import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099); // or we can use command line and run : rmiregistry 
			System.out.println("Server started");
			RemoteElement obj = new RemoteElement();
			Naming.bind("newRemoteElement", obj);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
