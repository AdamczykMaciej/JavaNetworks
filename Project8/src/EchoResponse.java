import java.io.Serializable;

public class EchoResponse implements Serializable {

	private static final long serialVersionUID = 2096219339996890304L;
	private String response;
	public EchoResponse(EchoRequest request) {
		response = request.getMessage();
	}
	
	public String getResponse() {
		return response;
	}
}
