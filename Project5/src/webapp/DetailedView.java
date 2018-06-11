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
@WebServlet(urlPatterns = { "/DetailedView" })
public class DetailedView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void serviceRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=windows-1250");

		HttpSession ses = request.getSession();

		PrintWriter out = response.getWriter();
		//System.out.println(ses.getAttribute("detailedResources"));
		ArrayList<Resource> resource = (ArrayList<Resource>) ses.getAttribute("detailedResources");
		for(int i = 0; i<resource.size(); i++) {
			out.println(resource.get(i).getName()+" "+resource.get(i).getContent());
		}
		//out.println(ses.getAttribute("detailedResources"));
		out.println();
		out.println("<form method=\"GET\" action=\"/Project5/Controller\"><input type=\"submit\" value=\"Back\" name=\"viewResponse\"/></form>");
		out.println();
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
