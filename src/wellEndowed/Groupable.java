package wellEndowed;

public interface Groupable {
	
	public User getUser(String userName);
	public void addUser(User user);
	public Groupable getGroup();
	public void setGroupName(String name);
	public String getGroupName();

}
