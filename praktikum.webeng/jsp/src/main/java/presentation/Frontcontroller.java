package presentation;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.Article_Manager;
import transfer.Article;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(urlPatterns ={ "/Frontcontroller" })
public class Frontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Frontcontroller() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession(true);
		RequestDispatcher rd_editArticles = request.getRequestDispatcher("/protected/editArticles.jsp");
		RequestDispatcher rd_list = request.getRequestDispatcher("list.jsp");
		RequestDispatcher rd_cart = request.getRequestDispatcher("cart.jsp");
		RequestDispatcher rd_checkout = request.getRequestDispatcher("checkout.html");
		RequestDispatcher rd_details = request.getRequestDispatcher("details.jsp");
		Article_Manager  art_man = (Article_Manager) session.getAttribute("art_man");
		@SuppressWarnings("unchecked")
		ArrayList<Article> shoppingCart = (ArrayList<Article>) session.getAttribute("shoppingCart");
		if(art_man == null || shoppingCart == null) {
			art_man = new Article_Manager();
			shoppingCart = new ArrayList<Article>();
			session.setAttribute("shoppingCart", shoppingCart);
			session.setAttribute("art_man", art_man);
			session.setAttribute("articleList", art_man.getAll());
		}
		if(action !=null)
			switch(action) {
			case "admin":
				rd_editArticles.forward(request, response);
				break;
			case "articlelist":
				rd_list.forward(request, response);
				break;
			case "details":
				rd_details.forward(request, response);
				break;
			case "checkout":
				shoppingCart.clear();
				rd_checkout.forward(request, response);
				break;
			case "edit":
				art_man.update(new Article(Integer.parseInt(request.getParameter("id")), 
															request.getParameter("name"), 
															Float.valueOf(request.getParameter("price")), 
															Integer.parseInt(request.getParameter("quantity"))));
				rd_editArticles.forward(request, response);
				break;
			case "delete":
				art_man.delete(art_man.get(Integer.parseInt(request.getParameter("id"))));
				rd_editArticles.forward(request, response);
				break;
			case "insert":
				art_man.add(new Article(Integer.parseInt(request.getParameter("id")),
						request.getParameter("name"),
						Float.valueOf(request.getParameter("price")),
						Integer.parseInt(request.getParameter("quantity"))));
				rd_editArticles.forward(request, response);
				break;
			case "cart":
				int id = Integer.parseInt(request.getParameter("id"));
				Article a = art_man.get(Integer.parseInt(request.getParameter("id")));
				art_man.decrementQuantity(a,Integer.parseInt(request.getParameter("quantity")));
				a.setQuantity(Integer.parseInt(request.getParameter("quantity")));
				shoppingCart.add(new Article(a.getId(),a.getName(),a.getPrice(),Integer.parseInt(request.getParameter("quantity"))));
				rd_cart.forward(request, response);
				break;
			default:
			}
		else;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
