package wellEndowed;

import java.util.List;

public interface MessageChatable {

	public List<User> getChatUsers();
	public void setChatUsers(List<User> chatUsers);
	public List<Message> getMessages();
	public void setMessages(List<Message> messages);
	public void addMessage(Message message);
	
	
	
	
}
