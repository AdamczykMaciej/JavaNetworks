package proj4;

import javax.servlet.http.HttpServlet;

public class Error extends HttpServlet {
	
	private String message;
	
	public Error(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
