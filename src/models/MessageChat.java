package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

public class MessageChat 
{
	
	@Id
	@Column(name="id")
	@SequenceGenerator(name="account_seq", sequenceName="account_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_seq")
	private int id;	
	
	@ManyToMany(mappedBy="user")
	private List<User> chatUsers;
	
	@ManyToMany(mappedBy="messages")
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