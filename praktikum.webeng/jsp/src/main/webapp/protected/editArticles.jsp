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
			Article_Manager art_Man = (Article_Manager) request.getSession().getAttribute("art_man");
			for(Article a : art_Man.getAll()){%>
					<tr>
					<td>
						<form action="Frontcontroller" method="get">
						<input type="number" name="id" value="<%=a.getId() %>">
						<input type="text" name="name" value="<%=a.getName() %>">
						<input type="number" name="price" value="<%=a.getPrice() %>">
						<input type="number" name="quantity" value="<%=a.getQuantity() %>">
						<input type="number" name="AuthToken" value="<%=((HttpServletRequest) request).getParameter("AuthToken")%>" hidden="True">
						<button type="submit" name="action" value="edit" >Ändern</button>
						<button type="submit" name="action" value="delete" >Löschen</button>
						</form>
					</td>
					</tr>
			<%} %>
			<tr>
					<td>
						<form action="Frontcontroller" method="get">
						<input type="number" name="id">
						<input type="text" name="name" >
						<input type="number" name="price" >
						<input type="number" name="quantity">
						<input type="number" name="AuthToken" value="<%=((HttpServletRequest) request).getParameter("AuthToken")%>" hidden="True">
						<button type="submit" name="action" value="insert">Hinzufügen</button>
						</form>
					</td>
			</tr>

          </table>
          </main>
    </body>
</html>