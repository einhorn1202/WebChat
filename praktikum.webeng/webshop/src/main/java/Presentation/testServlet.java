package Presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogic.Manager_Article;
import BusinessLogic.Manager_ShoppingCart;
import DataAccessLayer.WebShopDAO;
import TransferObject.ArticleDTO;
import TransferObject.ShoppingCartDTO;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(urlPatterns ={ "/testServlet" })
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html><head></head><body><main>");
		out.println("<h1> 1. Artikel anzeigen</h1>");
		
		// Artikel anzeigen
		
		Manager_Article art_Man = new Manager_Article();
		Manager_ShoppingCart cart_Man = new Manager_ShoppingCart();
		
		
		
		out.println("<table>");
		out.println("<tr>"
				+ "<th>ArtikelNr</th>"
				+ "<th>Name</th>"
				+ "<th>Preis</th>"
				+ "<th>Bestand</th>");
		for(ArticleDTO articleElement : art_Man.getArticleList()) {
			out.println("<tr>" +
						"<td>" + articleElement.getID()  + "</td>" +
						"<td>" + articleElement.getName()  + "</td>" +
						"<td>" + articleElement.getPrice()  + "</td>" +
						"<td>" + articleElement.getQuantity()  + "</td>");
		}
		out.println("</table>");
		
		//Hinzufügen von 3 Artikeln zum Warenkorb 
		out.println("<h1> 2. Hinzufügen von 3 Artikeln zum Warenkorb</h1>");
		
		cart_Man.addArticleShoppingCart(art_Man.getArticleList().get(3));
		cart_Man.addArticleShoppingCart(art_Man.getArticleList().get(2));
		cart_Man.addArticleShoppingCart(art_Man.getArticleList().get(1));
		
		out.println("<h1> 3. Ausgabe des Warenkorbs inkl. des Summenbetrags </h1>");
		out.println("<table>");
		out.println("<tr>"
				+ "<th>ArtikelNr</th>"
				+ "<th>Name</th>"
				+ "<th>Preis</th>"
				+ "<th>Bestand</th>");
		for(ArticleDTO articleElement : cart_Man.getShoppingCart().getShoppingCartList()) {
			//Dekrementiere den Artikel
			out.println("<tr>" +
						"<td>" + articleElement.getID()  + "</td>" +
						"<td>" + articleElement.getName()  + "</td>" +
						"<td>" + articleElement.getPrice()  + "</td>" +
						"<td align=\"right\">" + articleElement.getQuantity()  + "</td></tr>");
			art_Man.decrementQuantity(articleElement);
		}
		
		out.println("<tr ><td align=\"right\" colspan=\"4\">Gesamt: "+  cart_Man.getTotal() +"</td></tr>");
		out.println("</table>");
		
		
		out.println("<h1> 3. Ausgabe der aktualisierten Artikelliste</h1>");
		
		// Artikel anzeigen
		out.println("<table>");
		out.println("<tr>"
				+ "<th>ArtikelNr</th>"
				+ "<th>Name</th>"
				+ "<th>Preis</th>"
				+ "<th>Bestand</th>");
		for(ArticleDTO articleElement : art_Man.getArticleList()) {
			out.println("<tr>" +
						"<td>" + articleElement.getID()  + "</td>" +
						"<td>" + articleElement.getName()  + "</td>" +
						"<td>" + articleElement.getPrice()  + "</td>" +
						"<td>" + articleElement.getQuantity()  + "</td>");
		}
		out.println("</table>");
		
		out.println("<h1> 4. Ausgabe des leeren Warenkorbs nach einem Checkout\r\n</h1>");
		cart_Man.clearShoppingCart();
		// Artikel anzeigen
		out.println("<table>");
		out.println("<tr>"
				+ "<th>ArtikelNr</th>"
				+ "<th>Name</th>"
				+ "<th>Preis</th>"
				+ "<th>Bestand</th>");
		for(ArticleDTO articleElement : cart_Man.getShoppingCart().getShoppingCartList()) {
			out.println("<tr>" +
						"<td>" + articleElement.getID()  + "</td>" +
						"<td>" + articleElement.getName()  + "</td>" +
						"<td>" + articleElement.getPrice()  + "</td>" +
						"<td align=\"right\">" + articleElement.getQuantity()  + "</td></tr>");
		}
		out.println("</table>");
		out.println("</main></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
