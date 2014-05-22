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
	@Column(name="profilePicture")
	private Image profilePicture;
	
	private Group followers;
	private Group following;
	private List<Group> groups;
	private List<Post> posts;
	private List<MessageChat> messageChat;
	
	public User(String firstName, String lastName, String userName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.setUserName(userName);
		this.followers = new Group(this, userName+"FOLLOWERS");
		this.following = new Group(this, userName+"FOLLOWING");
		this.groups = new ArrayList<Group>();
		this.groups.add(followers);
		this.groups.add(following);
		this.posts = new ArrayList<Post>();
		this.messageChat = new ArrayList<MessageChat>();
		this.profilePicture = null;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

}
