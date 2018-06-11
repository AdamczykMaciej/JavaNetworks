package proj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;



/**
 * Servlet implementation class Calculator
 */
@WebServlet(urlPatterns = {"/calculator"})
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculator() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	PrintWriter out;

	public void serviceRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		out = resp.getWriter();
		Map<String, String[]> map = req.getParameterMap();
		double sum=0;
		for(Map.Entry<String, String[]> entry: map.entrySet()) {
			sum+=Double.parseDouble(entry.getValue()[0]);
		}
		out.println("SUM: "+sum);
		out.close();
		
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		serviceRequest(req,resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		serviceRequest(req,resp);
	}

}
