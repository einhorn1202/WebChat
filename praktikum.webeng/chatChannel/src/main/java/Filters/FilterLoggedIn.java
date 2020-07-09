package Filters;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import PresentationLayer.*;
import TransferObjects.*;
import javax.inject.*;
//@WebFilter(filterName="FilterLoggedIn", urlPatterns = {"/PROTECTED/*"})
public class FilterLoggedIn implements javax.servlet.Filter {
	
	
	@Inject
	UserBean userBean;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(userBean.getLoginUsername().compareTo("") != 0)
			chain.doFilter(request, response);
		else {
			((HttpServletResponse) response).sendError(403, "Sie sind nicht eingeloggt!");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}

