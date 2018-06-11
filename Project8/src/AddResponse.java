

import java.io.Serializable;

public class AddResponse implements Serializable {

	private static final long serialVersionUID = 2358775436812864698L;
	private int result;
	public AddResponse(AddRequest request) {
		result = request.getA() + request.getB();
	}
	
	public int getResult() {
		return result;
	}
}
