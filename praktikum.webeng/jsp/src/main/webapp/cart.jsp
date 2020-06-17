<%@ page import="java.io.*,java.util.*" %>
<%@ page import="logic.*" %>
<%@ page import="transfer.*" %>
<%@ page import="data.*" %>
<%@ page import="presentation.*" %>
<!doctype html>
<html>
    <head>
    </head>
    <body>
          <main>
          		<h1>Einkaufswagen</h1>
   				<table>
			<%
			ArrayList<Article> articleList =  (ArrayList<Article>) request.getSession().getAttribute("shoppingCart");
			for(Article a : articleList){
			%>
 						<tr>
						<td><%=a.getId() %></td>
						<td><%=a.getName() %></td>
						<td><%=a.getPrice() %></td>
						<td><%=a.getQuantity() %></td>
					</tr>
			<%} %>
          </table>
          </main>
    </body>
</html>