package models;

import java.io.File;
import java.util.Collections;
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

import wellEndowed.PasswordEncoder;

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
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="user",
			cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<UserRole> roles = new HashSet<>();
	
	public Set<UserRole> getRoles() 
	{
		return Collections.unmodifiableSet(roles);
	}
	
	public void addRole(Role role)
	{
		UserRole ur = new UserRole();
		ur.setRole(role);
		ur.setUser(this);
		ur.setUsername(userName);
		roles.add(ur);
	}
	
	public boolean hasRole(Role role) {
		for ( UserRole userRole : roles ) {
			if ( userRole.getRole().equals(role) ) {
				return true;
			}
		}
		return false;
	}

	public User(String firstName, String lastName, String userName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.setUserName(userName);
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
	
	public void addGroup(Group group){
		groups.add(group);
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
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		PasswordEncoder pe = new PasswordEncoder();
		this.password = pe.encode(password);
	}

	public Set<Group> getGroups(){
		return groups;
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
		return (id+ ") "+userName + ": " + firstName + " " + lastName);
	}

	@Override
	public int hashCode() {
		int hashCode = (int)Long.parseLong(id.toString());
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		return (this.toString().equalsIgnoreCase(obj.toString()));		
		
		

	}
	


}
