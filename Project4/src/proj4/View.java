package proj4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void serviceRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	
    	PrintWriter out = response.getWriter();
    	ServletContext context = getServletContext();
    	RequestDispatcher disp = context.getRequestDispatcher("/index.html");
    	disp.include(request, response);
    	Error error;
    	if((error = (Error)request.getAttribute("Error")) !=null) {
    		out.println(error.getMessage());
    		out.println("<br>");
    	}
    	Model model = (Model)request.getAttribute("Result");
    	out.println(model.getResult());
    	

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		serviceRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		serviceRequest(request, response);
	}

}
