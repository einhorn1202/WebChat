import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Counter implements HttpSessionListener {

	ServletContext context = null;
	static int total = 0;
	static int current = 0;
	
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		total ++;
		current ++;
		
		context = se.getSession().getServletContext();
		context.setAttribute("totalSession", total);
		context.setAttribute("currentSessions", current);
		
		System.out.println("Gesamtanzahl Sessions:" + total);
		System.out.println("Aktuelle Anzahl Session:" + current);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		current--;
		context.setAttribute("currentSessions", current);
		System.out.println("Aktuelle Anzahl Session:" + current);
		
	}

}
