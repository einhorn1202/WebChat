import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(urlPatterns ={ "/webeng02" })
public class webeng02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public webeng02() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd=request.getRequestDispatcher("Navigation");
		rd.include(request, response);
			
		
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html><head></head><body><main>");
		if(action !=null)
			switch(action) {
			case "home":
					welcome(out, request, response);
				break;
			case "header":
				out.println("<table>");
				Enumeration<String> headerList= request.getHeaderNames();
				Map<String,String> header_desc = new HashMap<String,String>();
				header_desc.put("Accept","Welche Formate werden Unterstütz bzw. akzeptiert.");
				header_desc.put("Host","Beschreibt, auf welcher Adresse der Webserver gehostet wird.");
				while(headerList.hasMoreElements()) {
					String name = headerList.nextElement();
					String value = request.getHeader(name);
					String tr = "<tr>" +
								"<td>" + name  + "</td>" +
								"<td>" + value + "</td>";
					if(header_desc.get(name) != null)
						tr += "<td>" + header_desc.get(name) + "</td>";
					tr += "</tr>";
					out.println(tr);
				}
				out.println("</table>");
				break;
			case "cookies":
				Cookie first_cookie = new Cookie("Nachname", "Meyer");
				first_cookie.setMaxAge(10000);
				response.addCookie(first_cookie);
				Cookie[] cookies = request.getCookies();
				if(cookies!= null) {
					for(int i=0; i<cookies.length;i++) {
						String name = cookies[i].getName();
						String value = cookies[i].getValue();
						out.println(name + " = "+ value);
					}
				}
				break;
			case "search": 
				
				out.println("<!doctype html>");
                out.println("<html><head></head><body><main>");
                out.println("<h1>Herzlich WELCOME lennart Meyer 797320</h1>");
                out.println("<form action= \"webeng02\">");
                out.println("<input type=\"text\" name=\"name\">");
                out.println("<input type=\"hidden\" name=\"action\" value=\"search\">");
                out.println("<input type=\"submit\" value=\"Google Search\">");
                String name = request.getParameter("name");
                if(name != null)
                	response.sendRedirect("https://www.google.com/#q=" +name);
                out.println("</form>");
				// String newURL = response.encodeRedirectURL("http://www.google.com");
				//response.sendRedirect(newURL);
				break;
			default:
			}
		else 
			welcome(out , request ,response);
		out.println("</main></body></html>");
	}
	
	public void welcome(PrintWriter out,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out.println("<a href=\"/Navigation/Navigation\">Navigation</a>");
		out.println("<h1>Herzlich Willkommen. Lennart Meyer 797320 </h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
