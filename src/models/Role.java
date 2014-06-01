package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
@NamedQueries({
	@NamedQuery(name="getRoleOfUser", query="SELECT r.rolename FROM Roles r WHERE r.username = :username")
})
public class Role 
{	
	@Id
	@Column(name="id")
	@SequenceGenerator(name="account_seq", sequenceName="account_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_seq")
	private Long id;
	
	@Column(name="username", unique=true)
	private String userName;
	
	@Column(name="rolename")
	private String roleName;
	
	public Role(String roleName, String userName)
	{
		this.roleName = roleName;
		this.userName = userName;
	}
}