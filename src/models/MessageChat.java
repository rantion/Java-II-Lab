package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MessageChat")
public class MessageChat 
{
	
	@Id
	@Column(name="id")
	@SequenceGenerator(name="account_seq", sequenceName="account_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_seq")
	private int id;	
	
	@ManyToMany(mappedBy="messageChats",fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.ALL})
	private List<User> chatUsers;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.ALL})
	@JoinTable(name="messageChat_message", 
	joinColumns=@JoinColumn(name="messagechat_id"),
	inverseJoinColumns=@JoinColumn(name="message_id"))
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