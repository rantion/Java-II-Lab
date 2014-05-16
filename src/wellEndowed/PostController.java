package wellEndowed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PostController {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Groupable members = ServiceLoader.members;
	
	public PostController(HttpServletRequest request, HttpServletResponse respnonse){
		this.request = request;
		this.response = response;
	}

}
