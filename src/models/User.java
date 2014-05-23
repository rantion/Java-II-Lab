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
	private List<MessageChat> messageChats;
	
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
		this.messageChats = new ArrayList<MessageChat>();
		this.profilePicture = null;
	}
	
	public void startMessageChat(List<User>users, String messageContent){
		users.add(this);
		MessageChat messageChat = new MessageChat(users);
		messageChat.addMessage(new Message(this, messageContent));
	}
	
	public void addFollower(User user){
		followers.addMember(user);
	}
	
	public void follow(User user){
		following.addMember(user);
		user.addFollower(this);
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void addMessageChat(MessageChat messageChat){
		if(!messageChats.contains(messageChat)){
		messageChats.add(messageChat);
		}
	}
	
	public void createNewGroup(String groupName, List<User> groupMembers){
		Group group = new Group(this,groupName);
		for(User user: groupMembers){
			group.addMember(user);
		}
		groups.add(group);
	}
	
	public Group getGroup(String groupName){
		Group _group = null;
		for(Group group : groups){
			if(group.getGroupName().equals(groupName)){
				_group = group;
			}
		}
		return _group;
	}
	
	public void removeGroup(String groupName){
		Group groupR = null;
		for(Group group : groups){
			if(group.getGroupName().equals(groupName)){
				groupR = group;
			}
		}
		groups.remove(groupR);
	}
	
	public void postReaction (Post post, Post reaction){
		
	}
	
	public void commentReaction(Post post, Comment reaction){
		
	}
	
	public void commentOnComment(Comment comment, Comment reply){
		
	}
	
	public List<MessageChat> getMessages(){
		return messageChats;
	}
	
	public Group getFollowers(){
		return followers;
	}
	
	public Group getFollowing(){
		return following;
	}
	
	@Override
	public String toString(){
		return (userName+": "+firstName+" "+lastName);
	}
	
	

}
