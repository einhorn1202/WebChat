package Listener;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CounterOfUsers implements HttpSessionListener {
	
	ServletContext context = null;
	static int total = 0;
	static int current = 0;
	
	@Override
	public synchronized void sessionCreated(HttpSessionEvent se) {
		total++;
		current++;
		
		context = se.getSession().getServletContext();
		context.setAttribute("totalSessions", total);
		context.setAttribute("currentSessions", current);
	}

	@Override
	public synchronized void sessionDestroyed(HttpSessionEvent se) {
		current--;
		context.setAttribute("currentSessions", current);
	}
}
