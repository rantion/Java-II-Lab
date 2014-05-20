package wellEndowed;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import models.Group;
@WebListener
public class ServiceLoader implements ServletContextListener {

	public static Group members;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
				
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		members = new Group("members");
	}

}
