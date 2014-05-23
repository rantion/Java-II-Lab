package models;

import java.util.ArrayList;
import java.util.List;

public class MessageChat 
{
	private List<User> chatUsers;
	private List<Message> messages;
	
	public MessageChat(List<User> users)
	{
		this.setChatUsers(users);
		this.messages = new ArrayList<Message>();
	}

	public List<User> getChatUsers() {
		return chatUsers;
	}

	public void setChatUsers(List<User> chatUsers) {
		this.chatUsers = chatUsers;
		for(User user: chatUsers){
			user.addMessageChat(this);
		}
	}
	
	public void addUser(User user){
		chatUsers.add(user);
		user.addMessageChat(this);
	}
	
	public List<Message> getMessages() {
		return messages;
	}
	
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	public void addMessage(Message message)
	{
		messages.add(message);
	}
}