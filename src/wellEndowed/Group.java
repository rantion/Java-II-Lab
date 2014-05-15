package wellEndowed;

import java.util.HashMap;
import java.util.List;

public class Group implements Groupable{
	private String name;
	private HashMap<String,User> members;
	
	public Group(String name){
		this.name = name;
		this.members = new HashMap<String, User>();
	}

	@Override
	public User getUser(String userName) {
		User user = members.get(userName);
		return user;
	}

	@Override
	public void addUser(User user) {
		members.put(user.getUserName(), user);
	}

	@Override
	public Groupable getGroup() {
		return this;
	}

	@Override
	public void setGroupName(String name) {
		this.name = name;
		
	}

	@Override
	public String getGroupName() {
		return name;
	}

}
