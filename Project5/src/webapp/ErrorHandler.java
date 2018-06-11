package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrorHandler")
public class ErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void serviceRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		 
		    response.setContentType("text/html; charset=UTF-8");
		    Throwable exc = (Throwable)
		                     request.getAttribute("javax.servlet.error.exception");

		    if (exc != null) {
		      PrintWriter out = response.getWriter();
		      out.println("<h2>" + exc.getMessage() + "</h2><hr>");
		      Throwable cause = exc.getCause();
		      if (cause instanceof SQLException) {
		        SQLException sqlexc = (SQLException) cause;
		        out.println(sqlexc.getMessage() + "<br><br>");
		        out.println("Error code: " + sqlexc.getErrorCode() + "<br>");
		        out.println("SQL state : " + sqlexc.getSQLState() + "<br>");
		      }
		      out.close();
		    }
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		serviceRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		serviceRequest(request, response);
	}

}
