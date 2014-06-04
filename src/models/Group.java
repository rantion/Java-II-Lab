package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Groups")
@NamedQueries({
	@NamedQuery(name="byGroupOwnerandName", query="SELECT g FROM Group g WHERE g.groupOwner = :groupOwner AND g.name = :groupName")
})
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
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="user_group", 
	joinColumns=@JoinColumn(name="groups_id"),
	inverseJoinColumns=@JoinColumn(name="user_id"))
	private Set<User> members = new HashSet<User>();

	public Group(String name) {
		this.name = name;
	}

	public Group(User groupOwner, String name) {
		this.groupOwner = groupOwner;
		this.name = name;
		this.members = new HashSet<User>();
	}
	
	public Group(){
		
	}

	public void addMember(User user) {
		members.add(user);
	}

	public void removeMember(User user) {
		members.remove(user.getUserName());
	}

	public Set<User> getGroup() {
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
