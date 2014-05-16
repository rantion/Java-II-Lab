package wellEndowed;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		
		String uri = request.getRequestURI();
		String page = "";
		Pattern regex = Pattern
				.compile("(?<start>\\/reaction\\/)(?<itemID>[0-9]+)?(\\/?)(?<page>[a-z]+)?");
		Matcher matcher = regex.matcher(uri);

		
		getController = new GetController(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		postController = new PostController(request, response);
	}

}
