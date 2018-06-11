package jms;

import java.io.Serializable;

public class RandomRequest implements Serializable {

	private static final long serialVersionUID = -6626558484376559576L;
	public String msg;

	public RandomRequest(String msg) {
		this.msg = msg;
	}
}
