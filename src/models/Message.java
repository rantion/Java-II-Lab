package models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Message")
public class Message{
	@Id
	@Column(name="id")
	@SequenceGenerator(name="account_seq", sequenceName="account_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_seq")
	private int id;	
	@Column(name="sender")
	@ManyToOne
	@JoinColumn(name="user_id")
	private User sender;
	
//	@Column(name = "dateSent")
//	private Calendar dateSent;
	@Column(name = "content")
	private String content;
//	private boolean isGroupMessage;
	
	public Message(User sender, String content)
	{
		this.sender = sender;
		this.content = content;
//		dateSent = Calendar.getInstance();
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}
	
//	public Calendar getDateSent() {
//		return dateSent;
//	}
//
//	public void setDateSent(Calendar dateSent) {
//		this.dateSent = dateSent;
//	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString(){
		return ("Sender: "+sender.toString()+": "+content);
	}

}