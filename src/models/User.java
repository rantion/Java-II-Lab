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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import wellEndowed.PasswordEncoder;

@Entity
@Table(name = "User")
@NamedQueries({
	@NamedQuery(name="getRoleOfUser", query="SELECT r.rolename FROM UserRole r WHERE r.username = :username")
})
public class User {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "account_seq", sequenceName = "account_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	private Long id;
	
	@Column(name = "username", unique = true)
	private String username;
	
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
		ur.setUsername(username);
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

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		PasswordEncoder pe = new PasswordEncoder();
		this.password = pe.encode(password);
	}	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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



	@Override
	public String toString() {
		return (username + ": " + firstName + " " + lastName);
	}

}
