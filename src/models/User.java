package models;

import java.awt.Image;
import java.io.File;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "account_seq", sequenceName = "account_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	private Long id;
	
	@Column(name = "username", unique = true)
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "bio")
	private String bio;
	
	@Column(name = "profilePicture")
	private File profilePicture;
	
	@ManyToMany(mappedBy="members",fetch=FetchType.LAZY)
	private Set<Group> groups = new HashSet<Group>();
	
	@ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.ALL})
	@JoinTable(name="user_post", 
	joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="post_id"))
	private Set<Post> posts = new HashSet<Post>();	
	
	@ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.ALL})
	@JoinTable(name="user_messageChat", 
	joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="messagechat_id"))
	private Set<MessageChat> messageChats;
	private Group followers;
	private Group following;

	public User(String firstName, String lastName, String userName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.setUserName(userName);
//		followers = new Group(this, userName + "FOLLOWERS");
//		following = new Group(this, userName + "FOLLOWING");
//		this.groups.add(followers);
//		this.groups.add(following);
		this.messageChats = new HashSet<MessageChat>();
		this.profilePicture = null;
	}
	
	public User(){
		
	}
	
	public Long getId(){
		return id;
	}

	public void startMessageChat(List<User> users, String messageContent) {
		users.add(this);
		MessageChat messageChat = new MessageChat(users);
		messageChat.addMessage(new Message(this, messageContent));
	}

	public void addFollower(User user) {
		followers.addMember(user);
	}

	public void follow(User user) {
		following.addMember(user);
		user.addFollower(this);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void addMessageChat(MessageChat messageChat) {
		if (!messageChats.contains(messageChat)) {
			messageChats.add(messageChat);
		}
	}

	public Group getGroup(String groupName) {
		Group _group = null;
		for (Group group : groups) {
			if (group.getGroupName().equals(groupName)) {
				_group = group;
			}
		}
		return _group;
	}

	public void removeGroup(String groupName) {
		Group groupR = null;
		for (Group group : groups) {
			if (group.getGroupName().equals(groupName)) {
				groupR = group;
			}
		}
		groups.remove(groupR);
	}

	public void postReaction(Post post, Post reaction) {

	}

	public void commentReaction(Post post, Comment reaction) {

	}

	public void commentOnComment(Comment comment, Comment reply) {

	}

	public Set<MessageChat> getMessages() {
		return messageChats;
	}

	public Group getFollowers() {
		Group followers = null;
		for (Group group : groups) {
			if (group.getGroupName().equals(userName + "FOLLOWERS")) {
				followers = group;
			}
		}
		return followers;
	}

	public Group getFollowing() {
		Group following = null;
		for (Group group : groups) {
			if (group.getGroupName().equals(userName + "FOLLOWING")) {
				followers = group;
			}
		}
		return followers;
	}

	@Override
	public String toString() {
		return (userName + ": " + firstName + " " + lastName);
	}

}
