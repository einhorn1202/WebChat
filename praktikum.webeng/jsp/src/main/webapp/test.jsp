<%@ page import="java.io.*,java.util.*" %>
<!doctype html>
<html>
    <head>
    </head>
    <body>
    <%! String verschluesselt;%>
    <%!public String verschluesseln_Ceasar(String param_m,String param_k){
    verschluesselt = "";
    if(param_m != null || param_k != null){
    	List<String> text = Arrays.asList(param_m.split(""));
    	int k = Integer.parseInt(param_k);
    	List<String> alphabet = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
		for(String wert : text) {
			int m = alphabet.indexOf(wert);
			int e = (m+k)%26;
			verschluesselt +=  alphabet.get(e);
		}
		
    }
    	return verschluesselt;
    }
    	
    %>
          <main>
          	<label>Aktuelles Datum: <%= new java.text.SimpleDateFormat().format(new java.util.Date()) %></label>
          	</br>
          	<label>10+10 = <%=10+10%></label>
          	<form action="test.jsp" id="person" method="post">
			<label class="h2" form="passwortGenerator">Passwortgenerator</label>
			    <label for="m">Passwort</label> 
			    <input type="text" name="m" maxlength="30" required>
			    <label for="k">Schlüssel</label>  
			    <input type="text" name="k" maxlength="40" required>
			    <button type="reset">Eingaben zurücksetzen</button>
			    <button type="submit">Eingaben absenden</button>
			</form>
			<% if(request.getParameter("m") != null){ %>
			<label>Das Passwort lautet  <%=verschluesseln_Ceasar(request.getParameter("m"),request.getParameter("k"))%> </label>
			<%}%>
			</br>
			<label> Die HTTP-Methode lautet : <%= request.getMethod()%></label>
			</br>
			<label>Der Wert lautet : <%=pageContext.getServletContext().getInitParameter("value")%></label>
          </main>
    </body>
</html>