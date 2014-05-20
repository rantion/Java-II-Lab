package models;

import java.util.Calendar;
import java.util.List;

public class Message{
	
	private User sender;
	private List<User> receivers;
	private Calendar dateSent;
	private String content;
//	private boolean isGroupMessage;
	
	public Message(User sender, List<User> receivers, String content)
	{
		this.sender = sender;
		this.receivers = receivers;
		this.content = content;
		dateSent = Calendar.getInstance();
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public List<User> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<User> receivers) {
		this.receivers = receivers;
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

//	public boolean isGroupMessage() {
//		return isGroupMessage;
//	}
//
//	public void setGroupMessage(boolean isGroupMessage) {
//		this.isGroupMessage = isGroupMessage;
//	}
}