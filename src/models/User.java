package models;

import java.awt.Image;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User{	
	@Id
	@Column(name="id")
	@SequenceGenerator(name="account_seq", sequenceName="account_seq", initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_seq")
	private Long id;	
	@Column(name="username", unique=true)
	private String userName;	
	@Column(name="password")
	private String password;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="bio")
	private String bio;	
	private Followers followers;
	private Following following;
	private List<Group> groups;
	private List<Post> posts;
	private List<Message>messages;
	private Image profilePicture;

	
	public User(String firstName, String lastName, String userName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.setUserName(userName);
		this.followers = new Followers();
		this.following = new Following();
		this.groups = new ArrayList<Group>();
		this.posts = new ArrayList<Post>();
		this.messages = new ArrayList<Message>();
		this.profilePicture = null;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

}
