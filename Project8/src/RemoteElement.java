import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteElement extends UnicastRemoteObject implements IAddition, IEcho {

	private static final long serialVersionUID = 606496971550514522L;

	public RemoteElement() throws RemoteException {
	}

	@Override
	public AddResponse add(AddRequest request) throws RemoteException {
		// TODO Auto-generated method stub
		return new AddResponse(request);
	}

	@Override
	public EchoResponse echo(EchoRequest request) throws RemoteException {
		return new EchoResponse(request);
	}
}