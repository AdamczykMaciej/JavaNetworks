package jms;

public class ResponseFactory {
	private static int id = -1;
	
	public static int generateId() {
		id++;
		return id;
	}
}
