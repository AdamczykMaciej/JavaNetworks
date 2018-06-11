package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import listeners.Report;

@WebServlet(urlPatterns = { "/Calculate" })
public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void serviceConnection(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		double p1 = 0, p2 = 0;
		try {
			p1 = Double.parseDouble(request.getParameter("p1"));
			p2 = Double.parseDouble(request.getParameter("p2"));
		} catch (NumberFormatException e) {
			System.out.println("p1 or p2 is null or not a number");
		}
		double sum = p1 + p2;
		
		// printing a report (listeners' events)
		List<String> list = Report.get();
		System.out.println(list.size());
		out.println("<ol>");
		for (Iterator it = list.iterator(); it.hasNext();) {
			String answer = (String) it.next();
			out.println("<li>" + answer + "</li>");
			System.out.println(answer);
		}
		out.println("</ol>");

		out.println(sum);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		serviceConnection(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		serviceConnection(request, response);
	}
}