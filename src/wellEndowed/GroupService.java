package wellEndowed;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.Group;
import models.User;
@Stateless
@LocalBean
public class GroupService {
	
	@PersistenceContext(name="reactionDistractionUnit")
	private EntityManager em;
	
	public void addGroup(Group group){
		em.persist(group);
	}

	public void updateGroup(Group group){
		em.persist(group);
	}
	
	public Group getGroup(User groupOwner, String groupName) {
		Group group = null;
		try{
			group = (Group)em.createNamedQuery("byGroupOwnerandName")
		.setParameter("groupOwner", groupOwner).setParameter("groupName", groupName).getSingleResult();
		}
		catch(Exception e){
			group = null;
		}
		return group;
	}
	
	public void createNewGroup(User groupOwner, String groupName,
			User... groupMembers) {
		Group group = new Group(groupOwner, groupName);
		for (User user : groupMembers) {
			group.addMember(user);
		}
		em.persist(group);
	}
	
}
