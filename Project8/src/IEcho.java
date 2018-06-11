

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEcho extends Remote {
	public EchoResponse echo (EchoRequest request) throws RemoteException;
}
