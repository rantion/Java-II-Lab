package wellEndowed;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Comment;
import models.Group;
import models.Post;
import models.User;

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
	@Inject private CommentService cs;
	@Inject private PostService ps;
       
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
				System.out.println("starting Testing");
				ms.deleteUsers();
				gs.removeGroups();
				List<Group> groups = gs.getGroups();
				System.out.println(groups);
				User user = new User("Rachel", "Antion", "rantion");
				User user1 = new User("Luis", "Heinecke", "lheinecke");
				User user2 = new User("Daniel","Morroquin", "dmorroquin");
				User user3 = new User("Tyler", "Howes", "thowes");
				User user4 = new User("Josh", "Cummings", "jcummings");
			
				ms.addUser(user);
				ms.addUser(user1);
				ms.addUser(user3);
				ms.addUser(user2);
				
				gs.startFollowing(user, user2);
				Group group = gs.getGroup(user2, user2.getUserName()+"FOLLOWERS");
				group.printMembers();
				
//				gs.createNewGroup(user,"coolKids",user1, user2, user3);
//				Group group =gs.getGroup(user, "coolKids");
//				group.addMember(user4);
//				System.out.println(ms.getUser("rantion"));
//				Post post = new Post();
//				ps.addPost(post);
//				Comment comment = new Comment(user, post, "FUCK");
//				Comment comment2 = new Comment(user, comment, "ME");
//				cs.addComment(comment);
//				cs.addComment(comment2);
//				List<Comment> comments = cs.getCommentsByComment(comment);	
//				for(Comment com: comments){
//					System.out.println(com);
//				}
				
				
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
