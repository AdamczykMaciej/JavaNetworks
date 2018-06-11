package jms;

public class RequestorFactory {
	private static int id = -1;
	
	public static int generateId() {
		id++;
		return id;
	}
}
