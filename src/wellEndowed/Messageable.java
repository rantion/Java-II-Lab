package wellEndowed;

import java.util.Calendar;
import java.util.List;

public interface Messageable {

	public User getSender();
	public void setSender(User sender);
	public List<User> getReceivers();
	public void setReceivers(List<User> receivers);
	public Calendar getDateSent();
	public void setDateSent(Calendar dateSent);
	public String getContent();
	public void setContent(String content);
	
	
	
}
