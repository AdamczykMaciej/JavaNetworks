package listeners;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener{

  public void contextInitialized(ServletContextEvent event) {
     Report.add("Context was successfully created");
     ServletContext context = event.getServletContext();
     context.setAttribute("Number", new Integer(1));
     System.out.println("Context was started");
  }

  public void contextDestroyed(ServletContextEvent event) {
	  Report.add("Context was destroyed");
	  ServletContext context = event.getServletContext();
	  context.setAttribute("Number2", new Integer(1));
	  System.out.println("Context was destroyed");
  }
}