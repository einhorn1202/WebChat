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
   				<table>
			<%
			ArrayList<Article> articleList =  (ArrayList<Article>) request.getSession().getAttribute("articleList");
			Article a = articleList.get(Integer.parseInt(request.getParameter("id")));
			%>
 						<tr>
						<td><%=a.getId() %></td>
						<td><%=a.getName() %></td>
						<td><%=a.getPrice() %></td>
						<td><%=a.getQuantity() %></td>
						<td>
						<form action="Frontcontroller" method="get">
						<input name="id" value="<%=a.getId()%>" hidden="true">
						<label><input type="number"  name="quantity" min="1" step="1" value="1" max="<%=a.getQuantity()%>">Stk.</label>
						<button type="submit" name="action" value="cart" >In den Einkaufswagen</button>
						</form>
					</tr>
          </table>
          </main>
    </body>
</html>