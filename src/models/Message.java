package models;

import java.util.Calendar;
import java.util.List;

public class Message{
	
	private User sender;
	private Calendar dateSent;
	private String content;
	private MessageChat messageChat;
//	private boolean isGroupMessage;
	
	public Message(User sender, User receiver, String content, MessageChat messageChat)
	{
		this.sender = sender;
		this.content = content;
		this.messageChat = messageChat;
		dateSent = Calendar.getInstance();
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}
	
	public Calendar getDateSent() {
		return dateSent;
	}

	public void setDateSent(Calendar dateSent) {
		this.dateSent = dateSent;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}