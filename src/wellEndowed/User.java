package wellEndowed;

import java.awt.Image;
import java.util.List;
import java.util.ArrayList;

public class User {
	
	private String firstName, lastName, bio, userName;
	private Groupable followers, following;
	private List<Groupable> groups;
	private List<Post> posts;
	private List<Message>messages;
	private Image profilePicture;

	
	public User(String firstName, String lastName, String userName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.setUserName(userName);
		this.followers = new Group(userName+" followers");
		this.following = new Group(userName+" following");
		this.groups = new ArrayList<Groupable>();
		this.posts = new ArrayList<Post>();
		this.messages = new ArrayList<Message>();
		this.profilePicture = null;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

}
