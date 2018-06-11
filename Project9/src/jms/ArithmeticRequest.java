package jms;

import java.io.Serializable;

public class ArithmeticRequest implements Serializable {

	private static final long serialVersionUID = 1004199383508603508L;
	public int requestorId;
	public int a;
	public int b;
	public String operationType;
	public ArithmeticRequest(int requestorId,String operationType ,int a, int b) {
		this.requestorId = requestorId;
		this.a=a;
		this.b=b;
		this.operationType = operationType;
	}
}
