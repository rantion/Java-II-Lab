package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	private Long id;	
	
	@Column(name="subject")
	private String subject;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade={CascadeType.PERSIST, CascadeType.ALL})
	@JoinTable(name = "user_messageChat", joinColumns = @JoinColumn(name = "messagechat_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> chatUsers = new HashSet<User>();
	
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.ALL})
	private Set<Message> messages = new HashSet<Message>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<User> getChatUsers() {
		return chatUsers;
	}

	public void setChatUsers(Set<User> chatUsers) {
		this.chatUsers = chatUsers;
	}
	
	public void addUser(User user){
		chatUsers.add(user);
	}
	
	public Set<Message> getMessages() {
		return messages;
	}

	
	public void addMessage(Message message)
	{
		messages.add(message);
	}
	
	public String getSubject(){
		return subject;
	}
	
	public void setSubject(String subject){
		this.subject = subject;
	}
	
	@Override
	public String toString(){
		String messageLog = "";
		for(Message message: messages){
			messageLog+= message+"\n";
		}
		String toString = getId().toString()+") MESSAGE CHAT: Users: "+ chatUsers+"\n Subject: " +subject+"\n Messages: "+ messageLog;
		return toString;
	}

	public void addChatUser(User user) {
		chatUsers.add(user);
	}
}
	
