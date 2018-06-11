import java.io.Serializable;

public class EchoRequest implements Serializable {
	private static final long serialVersionUID = -7738196983632069061L;
	private String message;
	
	public EchoRequest(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
