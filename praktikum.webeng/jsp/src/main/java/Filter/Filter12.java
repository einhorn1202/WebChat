package Filter;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(filterName="Filter12", 
			urlPatterns = {"/protected/*"},  
			dispatcherTypes = {DispatcherType.FORWARD})
public class Filter12 implements javax.servlet.Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String authToken = ((HttpServletRequest) request).getParameter("AuthToken");
		if(authToken.compareTo(((HttpServletRequest) request).getServletContext().getInitParameter("token")) != 0)
			((HttpServletResponse) response).sendError(403, "Falscher Authentifizerungstoken!");
		else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}