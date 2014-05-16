package wellEndowed;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class ServiceLoader implements ServletContextListener {

	public static Groupable members;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
				
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		members = new Group("members");
	}

}
