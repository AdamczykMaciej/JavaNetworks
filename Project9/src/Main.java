import jms.Requestor;
import jms.Service;

public class Main {
	public static void main(String[] args) {
		// first we have to start ActiveMQ in its folder start in a terminal the command -> activemq.bat start
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread() {
				
				@Override
				public void run() {
					Service serv = new Service();
					serv.run();
				}
			};
			thread.start();
		}
		
		// SERVICES will be still running, because originally I wanted them to handle all intervening requests, so they have no idea how many requests they will get
		// due to that we could create Senders as other applciations and send requests to the services, they will be still trying to handle the requests

		String[] requests = { "Addition 2 2", "Multiplication 3 3", "Random Hey" };
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread() {
				
				@Override
				public void run() {
					Requestor req = new Requestor(requests);
					req.run();
				}
			};
			thread.start();
		}

	}
}
