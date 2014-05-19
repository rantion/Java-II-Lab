package wellEndowed;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletMain
 */
@WebServlet("/reaction/*")
public class ServletMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GetController getController;
	private PostController postController;
       
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
		getController = new GetController(request, response);
		
		String uri = request.getRequestURI();
		String page = "";
		String userName = "";
		Pattern regex = Pattern
				.compile("(?<start>\\/reaction\\/)(?<page>[a-z]+)?(\\/)?(?<userName>[a-z0-9]+)");
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		postController = new PostController(request, response);
	}

}
