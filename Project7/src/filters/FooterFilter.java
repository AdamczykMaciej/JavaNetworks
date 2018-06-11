package filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "footer", urlPatterns = { "*.servlet", "*.html" })
public class FooterFilter implements Filter {

	public void init(FilterConfig p0) throws ServletException {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		StringResponseWrapper newResp = new StringResponseWrapper((HttpServletResponse) resp);
		chain.doFilter(req, newResp);
		StringWriter sw = newResp.getStringWriter();

		// Uzyskujemy tre�� wygenrowanej odpowiedzi
		String cont = sw.toString();
	System.out.println(cont);

		// Teraz mo�emy zrobi� cokolwiek z odpowiedzi�
		// tu tylko dopiszemy do niej "stopk�"

		// Bierzemy strumie� oryginalnej odpowiedzi
		PrintWriter out = resp.getWriter();

		// Przepisujemy otrzyman� odpowied�
		out.println(cont);

		// Dopisujemy stopk�
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM);
//		out.println(newResp.getStringWriter().toString());
		out.println("<div id=\"date\">&nbsp</div></body></html>");
		out.close();
	}

	public void destroy() {
	}
}