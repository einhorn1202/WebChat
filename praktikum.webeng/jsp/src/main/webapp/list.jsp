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
			for(Article a : articleList){
			%>
 						<tr>
						<td><%=a.getName() %></td>
						<td><a href="details.jsp?id=<%=a.getId()%>"><button>Mehr Anzeigen</button></a></td>
					</tr>
			<%} %>
          </table>
          </main>
    </body>
</html>