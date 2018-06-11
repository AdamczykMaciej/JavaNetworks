package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent event) {
		Report.add("Request was successfully destroyed");
		ServletContext context = event.getServletContext();
		context.setAttribute("Number", new Integer(1));
		System.out.println("request being sent to " + event.getServletRequest().getRemoteAddr());
	}

	public void requestInitialized(ServletRequestEvent event) {
		Report.add("Request was successfully created");
		ServletContext context = event.getServletContext();
		context.setAttribute("Number", new Integer(1));
		System.out.println("now initializing request" + event.getServletRequest().getRemoteAddr());

	}
}
