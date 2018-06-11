package main;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Date" })
public class Date extends HttpServlet {
	private static final long serialVersionUID = -8538091245084118316L;

	private void serviceConnection(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		PrintWriter out = response.getWriter();
		
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String date = inputFormat.format(new java.util.Date());
		//String outputText = outputFormat.format(date);
		//System.out.println(date);
		out.write("{ \"date\":\""+date+"\" }");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			serviceConnection(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			serviceConnection(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}