package jms;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

public class Requestor {
	private int id;
	private final static Logger LOGGER = Logger.getLogger("log4j");
	private String[] requests;

	public Requestor(String[] requests) {
		id = RequestorFactory.generateId();
		this.requests = requests;
	}

	public int getId() {
		return id;
	}

	public void printMsg(Message message) throws Exception {
		if (message instanceof TextMessage) {
			TextMessage text = (TextMessage) message;
			LOGGER.info("Requestor " + getId() + " received: " + text.getText());
		} else if (message != null) {
			System.out.println("Received non text message");
		}
		// actually it will not be invoked, because in the implementation we print a Random message just at the service side. But we could handle printing on the requesto's side.
	}

	public void run() {
		String[] reqEls = null; // elements of a request
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
			con = factory.createConnection();
			Session ses = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			for (int i = 0; i < requests.length; i++) {
				reqEls = requests[i].split(" ");
				String admDestName = "MyQueue";
				Destination dest = (Destination) ctx.lookup(admDestName);
				MessageProducer sender = ses.createProducer(dest);

				con.start();

				if (reqEls[0].equals("Addition") || reqEls[0].equals("Subtraction")
						|| reqEls[0].equals("Multiplication") || reqEls[0].equals("Division")) {
					ArithmeticRequest obj = new ArithmeticRequest(getId(), reqEls[0], Integer.parseInt(reqEls[1]),
							Integer.parseInt(reqEls[2]));
					ObjectMessage msg = ses.createObjectMessage(obj);

					sender.send(msg);
				} else if (reqEls[0].equals("Random")) {
					TextMessage msg = (TextMessage) ses.createTextMessage();
					msg.setText(reqEls[1]);
					sender.send(msg);
				}

				LOGGER.info("Requestor " + getId() + " put into JMS destination: " + requests[i]);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			System.exit(1);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (JMSException exc) {
					System.err.println(exc);
				}
			}
		}

		// handling a response of a Service
		try {
			Context ctx = new InitialContext();
			ActiveMQConnectionFactory factory = (ActiveMQConnectionFactory) ctx.lookup("ConnectionFactory");
			factory.setTrustAllPackages(true);
			con = factory.createConnection();
			Session ses = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = ses.createQueue("MyQueue" + getId());
			MessageConsumer receiver = ses.createConsumer(queue);

			con.start();
			int responses = 0;
			while (responses<=requests.length) {
				Message message = receiver.receive();
				responses++;
				if (message instanceof TextMessage) {
					printMsg(message);
				} else if (message instanceof ObjectMessage) {
					ArithmeticResponse obj = (ArithmeticResponse) ((ObjectMessage) message).getObject();
					if (obj != null) {
						LOGGER.info("Requestor " + getId() + " received: " + obj.result);
					}
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			System.exit(1);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (JMSException exc) {
					System.err.println(exc);
				}
			}
		}

	}
}
