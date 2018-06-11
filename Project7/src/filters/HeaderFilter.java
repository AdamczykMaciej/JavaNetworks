package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "header", urlPatterns = { "*.servlet", "*.html" })
public class HeaderFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		// important that the scripts are here ( we need jquery)
		//we should store jquery locally
		out.println("<html><head>" + "<script\r\n" + "  src=\"https://code.jquery.com/jquery-3.3.1.min.js\"\r\n"
				+ "  integrity=\"sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=\"\r\n"
				+ "  crossorigin=\"anonymous\"></script>"
				+ "<script type=\"text/javascript\" language=\"javascript\" src=\"ajaxValidation.js\"></script>"
				+ "<script src='footer.js'></script>" + "</head><body>");
		out.println("<h>HEADER</h>" + "<br>");

		chain.doFilter(request, response);
	}

}
