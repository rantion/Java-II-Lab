package wellEndowed;

import java.util.HashMap;

public interface Groupable {
	
	public User getUser(String userName);
	public void addUser(User user);
	public HashMap<String, User> getGroup();
	public void setGroupName(String name);
	public String getGroupName();


}
