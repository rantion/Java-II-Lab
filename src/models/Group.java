package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

public class Group {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "account_seq", sequenceName = "account_seq", initialValue = 1, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User groupOwner;
	
	@Column(name = "name")
	private String name;
	@OneToMany(mappedBy="user")
	private HashSet<User> members;

	public Group(String name) {
		this.name = name;
		this.members = new HashSet<User>();
	}

	public Group(User groupOwner, String name) {
		this.groupOwner = groupOwner;
		this.name = name;
		this.members = new HashSet<User>();
	}

	public void addMember(User user) {
		members.add(user);
	}

	public void removeMember(User user) {
		members.remove(user.getUserName());
	}

	public HashSet<User> getGroup() {
		return members;
	}

	public void setGroupName(String name) {
		this.name = name;

	}

	public String getGroupName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

}
