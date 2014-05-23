package models;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Group{
	@Id
	@Column(name="id")
	@SequenceGenerator(name="account_seq", sequenceName="account_seq", initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_seq")
	private Long id;
	@Column(name = "groupOwner")
	private User groupOwner;
	@Column(name = "name")
	private String name;
	
	private HashMap<String, User> members;
	
	public Group (String name){
		this.name = name;
		this.members = new HashMap<String, User>();
	}
	
	public Group(User groupOwner, String name){
		this.groupOwner = groupOwner;
		this.name = name;
		this.members = new HashMap<String, User>();
	}

	public User getUser(String userName) {
		User user = members.get(userName);
		return user;
	}

	
	public void addMember(User user) {
		members.put(user.getUserName(), user);
	}
	
	public void removeMember(User user){
		members.remove(user.getUserName());
	}

		
	public HashMap<String, User> getGroup() {
		return members;
	}

	
	public void setGroupName(String name) {
		this.name = name;
		
	}

	
	public String getGroupName() {
		return name;
	}
	
	@Override
public String toString(){
	return name;	
	}

}
