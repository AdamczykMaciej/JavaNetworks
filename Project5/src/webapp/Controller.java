package webapp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	protected void serviceRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		HttpSession ses = request.getSession();
		RequestDispatcher disp;
		System.out.println(ses.getMaxInactiveInterval());
		System.out.println("CONTROLLER: ");
		System.out.println("Session ID: " + ses.getId());
		Db model = new Db();
		model.init();
		
		System.out.println(ses.getAttribute("authenticated"));
		Map<String, String[]> map = request.getParameterMap();
		System.out.println(map.keySet().toString());
		System.out.println(request.getParameterNames());
		String login = request.getParameter("login");
		System.out.println(login);
		String password = request.getParameter("password");
		
		if (model.authenticate(login, password) == true && ses.getAttribute("authenticated") == null) {

			System.out.println("Authenticated");
			model.serviceView(login, password);
			ses.setAttribute("authenticated", true);
			ses.setAttribute("authenticatedUser", new User(login, password));
			ses.setAttribute("resources", model.getResources());
			disp = context.getRequestDispatcher("/View");
			disp.forward(request, response);

		} else if (model.authenticate(login, password) == false && (ses.getAttribute("authenticated") == null
				|| (Boolean) ses.getAttribute("authenticated") == false)) {

			System.out.println("Unknown user");
			disp = context.getRequestDispatcher("/index.html");
			disp.include(request, response);

		} else if (request.getParameter("viewResponse") != null) {

			System.out.println("Response: "+request.getParameter("viewResponse"));

			if ((Boolean) ses.getAttribute("authenticated") == true) {
				if (request.getParameter("viewResponse").equals("Details")) {
					System.out.println("Go to detailed view");
					ses.setAttribute("resource", request.getParameter("resource"));
					model.serviceDetailedView((User)ses.getAttribute("authenticatedUser"), (String)ses.getAttribute("resource"));
					ses.setAttribute("detailedResources", model.getResources());
					disp = context.getRequestDispatcher("/DetailedView");
					disp.forward(request, response);

				} else if (request.getParameter("viewResponse").equals("LogOut")) {
			
					ses.invalidate(); // end the session
					System.out.println("Logged out, session invalidated");
					disp = context.getRequestDispatcher("/index.html");
					disp.include(request, response);
					
				} else if (request.getParameter("viewResponse").equals("Back")) {

					disp = context.getRequestDispatcher("/View");
					disp.forward(request, response);
					
				}
			}

			System.out.println("Response: "+request.getParameter("viewResponse"));

		} else {

			disp = context.getRequestDispatcher("/index.html");
			disp.include(request, response); // html only in include!!!

		}

		System.out.println("--------------------------------------");

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
