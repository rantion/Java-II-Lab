package wellEndowed;

import java.util.HashMap;
import java.util.List;

public class Group implements Groupable{
	private String name;
	private HashMap<String, User> members;
	
	public Group(String name){
		this.name = name;
		this.members = new HashMap<String, User>();
	}

	public User getUser(String userName) {
		User user = members.get(userName);
		return user;
	}

	
	public void addUser(User user) {
		members.put(user.getUserName(), user);
	}

		
	public Groupable getGroup() {
		return this;
	}

	
	public void setGroupName(String name) {
		this.name = name;
		
	}

	
	public String getGroupName() {
		return name;
	}

}
