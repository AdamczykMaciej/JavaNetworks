
import java.io.Serializable;

public class AddRequest implements Serializable {

	private static final long serialVersionUID = -349029201412966293L;
	private int a;
	private int b;

	public AddRequest(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
}
