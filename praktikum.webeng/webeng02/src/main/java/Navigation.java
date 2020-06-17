import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(urlPatterns ={ "/Navigation" })
public class Navigation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Navigation() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<!doctype html>");
		out.println("<html><head></head><body><header><ul>");
		out.println("<li><a href=\"/webeng02/webeng02?action=home\">Startseite</a></li>");
		out.println("<li><a href=\"/webeng02/webeng02?action=header\">Http-Header</a></li>");
		out.println("<li><a href=\"/webeng02/webeng02?action=cookies\">Cookies</a></li>");
		out.println("<li><a href=\"/webeng02/webeng02?action=search\">Search</a></li>");
		out.println("</ul></header><main></main></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("webeng02");
			dispatcher.forward(request, response);
		}
		doGet(request, response);
	}
}
