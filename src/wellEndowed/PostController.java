package wellEndowed;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Group;
import models.User;



public class PostController {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Group members = ServiceLoader.members;
	
	public PostController(HttpServletRequest request, HttpServletResponse respnonse){
		this.request = request;
		this.response = response;
	}
	
	public ModelAndView register(){
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		User newUser = new User(firstName, lastName, userName);
		ModelAndView mav = new ModelAndView(newUser,request.getContextPath()+"/reaction/profile/"+userName);
		return mav;
	}
	
	public ModelAndView uploadPost(){		
		return null;
	}
	
	public ModelAndView sendMessage(){
		return null;
	}
	
	public ModelAndView makeComment(){
		return null;
	}
	
	public ModelAndView searchMember(){
		String inquiry = request.getParameter("inquiry").toLowerCase();
		List<User> results = new ArrayList();
		Iterator it = members.getGroup().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, User> pair = (Map.Entry<String, User>)it.next();
			String userName = pair.getKey().toLowerCase();
			if(userName.contains(inquiry)){
				results.add(pair.getValue());
			}
		}
		return null;
	}


}
