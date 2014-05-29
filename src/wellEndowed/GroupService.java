package wellEndowed;

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
		Query w = em.createQuery("select i from Group i where groupOwner ='"+groupOwner+"%' and groupName ='"+groupName+"'");
		Group group = (Group)w.getSingleResult();
		return group;
	}
}
