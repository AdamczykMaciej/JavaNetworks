package jms;


import javax.jms.Connection;
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

public class Service {
	private int id;
	private final static Logger LOGGER = Logger.getLogger("A2");
	
	public Service(){
		id = ResponseFactory.generateId();
	}
	
	public int getId() {
		return id;
	}
	public void printMsg(Message message) throws Exception {
		if (message instanceof TextMessage) {
			TextMessage text = (TextMessage) message;
			LOGGER.info( "Service "+getId()+" received: " + text.getText());
		} else if (message != null) {
			System.out.println("Received non text message");
		}
	}

	public void run() {
		Connection con = null;
		try {

			Context ctx = new InitialContext();
			ActiveMQConnectionFactory factory = (ActiveMQConnectionFactory) ctx.lookup("ConnectionFactory");
			factory.setTrustAllPackages(true);
			String admDestName = "MyQueue";
			Destination dest = (Destination) ctx.lookup(admDestName);
	        con = factory.createConnection();
	        Session ses = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        MessageConsumer receiver = ses.createConsumer(dest);
			con.start();
			while (true) {
				Message message = receiver.receive();

				if (message instanceof TextMessage) {
					printMsg(message); // we just print message in the service, we don't return them (but we could, then we would need requestor's id)

				} else if (message instanceof ObjectMessage) {
					ArithmeticRequest obj = (ArithmeticRequest) ((ObjectMessage) message).getObject();
					if (obj != null) {
						ArithmeticResponse resp = new ArithmeticResponse(obj.requestorId, obj.operationType, obj.a, obj.b);

						Queue queue = ses.createQueue("MyQueue"+obj.requestorId);
						MessageProducer sender = ses.createProducer(queue);
						ObjectMessage msg = ses.createObjectMessage();
						msg.setObject(resp);
						
						sender.send(msg);
						LOGGER.info( "Service "+getId()+" sent response");
					}
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			System.exit(1);
		} finally {
			System.out.println();
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
