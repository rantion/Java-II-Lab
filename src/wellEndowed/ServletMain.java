package wellEndowed;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Group;
import models.Role;
import models.User;
import models.UserRole;

/**
 * Servlet implementation class ServletMain
 */
@WebServlet("/reaction/*")
public class ServletMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject private GetController getController;
	@Inject private PostController postController;
	@Inject private MemberService ms;
	@Inject private GroupService gs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String page = "";
		String userName = "";
		Pattern regex = Pattern
				.compile("(?<start>\\/reaction\\/)(?<page>[a-z]+)?(\\/)?(?<userName>[a-zA-Z0-9]*)");
		Matcher matcher = regex.matcher(uri);
		
		while (matcher.find()) {	
			if (matcher.group("page") != null) {
				page = matcher.group("page");
			}		
			if(matcher.group("userName")!=null){
				userName = matcher.group("userName");
			}
		}
		
		if(page.equals("newsfeed")){
			ModelAndView mav = getController.newsfeed();
			RequestDispatcher view = request.getRequestDispatcher(mav.getViewName());
			view.forward(request, response);
		}
		else if(page.equals("group") && !userName.equals("")){
			ModelAndView mav = getController.group();
			RequestDispatcher view = request.getRequestDispatcher(mav.getViewName());
			view.forward(request, response);
		}
		else if(page.equals("groups") && !userName.equals("")){
			ModelAndView mav = getController.groups();
			RequestDispatcher view = request.getRequestDispatcher(mav.getViewName());
			view.forward(request, response);
		}
		else if(page.equals("inbox") && !userName.equals("")){
			ModelAndView mav = getController.inbox();
			RequestDispatcher view = request.getRequestDispatcher(mav.getViewName());
			view.forward(request, response);
		}		
		else if(page.equals("profile") && !userName.equals("")){
			ModelAndView mav = getController.profile();
			RequestDispatcher view = request.getRequestDispatcher(mav.getViewName());
			view.forward(request, response);
		}
		else if(page.equals("login")){
			ModelAndView mav = getController.login();
			RequestDispatcher view = request.getRequestDispatcher(mav.getViewName());
			view.forward(request, response);			
		}
		else if(page.equals("register"))
		{
			ModelAndView mav = getController.register();
			RequestDispatcher view = request.getRequestDispatcher(mav.getViewName());
			view.forward(request, response);
			
		}
		else if(page.equals("testing")){
				ms.deleteUsers();
				User user = new User("Rachel", "Antion", "rantion");
				User user1 = new User("Luis", "Heinecke", "lheinecke");
				User user2 = new User("Daniel","Morroquin", "dmorroquin");
				User user3 = new User("Tyler", "Howes", "thowes");
				User user4 = new User("Josh", "Cummings", "jcummings");
				
				ms.addUser(user);
				ms.addUser(user1);
				ms.addUser(user3);
				ms.addUser(user2);
				
				gs.createNewGroup(user,"coolKids",user1, user2, user3);
				Group group =gs.getGroup(user, "coolKids");
				group.addMember(user4);
				System.out.println(ms.getUser("rantion"));
				
		}
//		else if( (page.equals("auth") && userName.equals("")) )
//		{
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			ms.deleteUsers();
//			User user = new User("Luis", "asdf", "react");
//			user.setPassword("asdf1234");
//			
//			user.addRole(Role.USER);
//			
//			ms.addUser(user);
//			
//			for(UserRole ur : user.getRoles())
//			{
//				System.out.println(ur);
//			}
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
