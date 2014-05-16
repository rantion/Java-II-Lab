package wellEndowed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetController {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Groupable members = ServiceLoader.members;
	
	public GetController(){
		
	}

}
