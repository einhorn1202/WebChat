import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class Stats
 */
@WebServlet(urlPatterns ={ "/protected/stats" })
public class Stats extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stats() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        ServletContext context = request.getServletContext();
        String referrer = request.getHeader("referer");

            out.println("<!doctype html>");
            out.println("<html><head></head><body>");
            out.println("<header><ul><li><a href=" + referrer + ">Zurück zum Protected Bereich</a></li></ul></header><main>");
            out.println("<h2>" + session.getAttribute("username") + "<h2>");
            out.println("<p>Eingeloggte User:" + context.getAttribute("currentSessions")+ "</p>");
            out.println("</main></body></html>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
