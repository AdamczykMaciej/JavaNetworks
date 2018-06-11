package proj4;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	protected void serviceRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		double p1 = 0, p2 = 0;
		try {
			p1 = Double.parseDouble(request.getParameter("p1"));
			p2 = Double.parseDouble(request.getParameter("p2"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			String message = "Too big input, or not of a numeric format";
			request.setAttribute("Error", new Error(message));
		}
		
		Model model = Logics.add(p1, p2);
		request.setAttribute("Result", model);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/View");
		dispatcher.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		serviceRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		serviceRequest(request, response);
	}

}
