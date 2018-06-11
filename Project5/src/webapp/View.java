package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class View
 */
@WebServlet(urlPatterns= {"/View"})
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void serviceRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html; charset=utf-8");

		HttpSession ses = request.getSession();
		System.out.println("ID:" + ses.getId());
		PrintWriter out = response.getWriter();
		ArrayList<Resource> resources = (ArrayList<Resource>) ses.getAttribute("resources");
		for(int i=0; i<resources.size(); i++) {
			out.println(resources.get(i).getName());
			out.println("<br>");
			out.println(
					"<form method=\'GET\' action=\'/Project5/Controller\'><input type=\'submit\' value=\'Details\' name=\'viewResponse\'>"
							+ "<input name=\'resource\' type=\'hidden\' value=\'"+resources.get(i).getName()+"\'>"
							+"</form>"
							+ "<br>");
			System.out.println(resources.get(i).getName());
		}
		
		
		out.println("<form method=\"GET\" action=\"/Project5/Controller\"><input type=\"submit\" value=\"LogOut\" name=\"viewResponse\"/></form>");
		out.close();

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
