package wellEndowed;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Group;

@Stateless
@LocalBean
public class GetController {
	@Inject private HttpServletRequest request;
	private Group members = ServiceLoader.members;
	
	public ModelAndView newsfeed(){
		ModelAndView nf = new ModelAndView(null, "/newsFeed.jsp");
		return nf;
	}
	
	public ModelAndView group(){
		ModelAndView group = new ModelAndView(null, "/group.jsp");
		return group;
	}
	
	public ModelAndView groups(){
		ModelAndView groups = new ModelAndView(null, "/groups.jsp");
		return groups;
	}
	
	public ModelAndView inbox(){
		ModelAndView inbox = new ModelAndView(null, "/inbox.jsp");
		return inbox;
	}
	
	public ModelAndView profile(){
		ModelAndView profile = new ModelAndView(null, "/profile.jsp");
		return profile;
	}
	
	public ModelAndView login(){
		ModelAndView login = new ModelAndView(null, "/index.jsp");
		return login;
	}
	
	public ModelAndView register(){
		ModelAndView register = new ModelAndView(null, "/register.jsp");
		return register;
	}

}
