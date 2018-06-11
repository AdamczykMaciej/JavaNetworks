package jms;

import java.io.Serializable;

public class ArithmeticResponse implements Serializable {

	private static final long serialVersionUID = -7149758277525623539L;
	public int requestorId;
	public int result;
	public ArithmeticResponse(int requestorId, String operationType, int a, int b) {
		this.requestorId = requestorId;
		if(operationType.equals("Addition")) {
			result = a + b;
		} else if(operationType.equals("Subtraction")) {
			result = a - b;
		} else if(operationType.equals("Multiplication")) {
			result = a * b;
		} else if(operationType.equals("Division")) {
			result = a / b;
		}
	}
}
