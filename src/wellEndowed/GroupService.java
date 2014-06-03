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

	@PersistenceContext(name = "reactionDistractionUnit")
	private EntityManager em;

	public void addGroup(Group group) {
		em.persist(group);
	}

	public void updateGroup(Group group) {
		em.persist(group);
	}

	public Group getGroup(User groupOwner, String groupName) {
		Group group = null;
		try {
			group = (Group) em.createNamedQuery("byGroupOwnerandName")
					.setParameter("groupOwner", groupOwner)
					.setParameter("groupName", groupName).getSingleResult();
			// System.out.println("inside Try: Group: " + group);
		} catch (Exception e) {
			group = null;
			// System.out.println("inside Catch: Group: " + group);
		}
//		System.out.println("returning, Group: " + group);
		return group;
	}

	public void createNewGroup(User groupOwner, String groupName,
			User... groupMembers) {
		Group group = new Group(groupOwner, groupName);
		groupOwner.addGroup(group);
		for (User user : groupMembers) {
			group.addMember(user);
		}
		em.persist(group);
//		groupOwner.addGroup(group);
//		em.persist(groupOwner);
	
	}

	public void addMemberToGroup(Group group, User memberToAdd) {
		group.addMember(memberToAdd);
		em.persist(group);
		em.persist(group.getGroupOwner());
	}
	
	public void deleteGroup(Group group){
		em.remove(group);
	}
	
	public void removeMemberFromGroup(Group group, User memberToRemove){
		group.removeMember(memberToRemove);
		em.persist(group);
		em.persist(group.getGroupOwner());
		
	}

	public List<Group> getGroups() {
		return em.createQuery("select g from Group g").getResultList();
	}

	public void removeGroups() {
		List<Group> groups = getGroups();
		for (Group group : groups) {
			em.remove(group);
		}
	}

	public void startFollowing(User user, User following) {
		Group group = getGroup(following, following.getUserName() + "FOLLOWERS");
		Group group1 = getGroup(user, user.getUserName() + "FOLLOWING");
		if (group == null) {
			System.out.println("creating "+following.getId()+" "+following.getUserName()+"FOLLOWERS");
			createNewGroup(following, following.getUserName() + "FOLLOWERS",
					user);
		} else {
			addMemberToGroup(group, user);
		}
		if (group1 == null) {
			System.out.println("creating "+user.getId()+" "+user.getUserName()+"FOLLOWING");
			createNewGroup(user, user.getUserName() + "FOLLOWING", following);
		} else {
			addMemberToGroup(group1, following);
		}
	}
	
	public void unfollow(User user, User unfollowing){
		Group group = getGroup(unfollowing, unfollowing.getUserName() + "FOLLOWERS");
		Group group1 = getGroup(user, user.getUserName() + "FOLLOWING");
		removeMemberFromGroup(group,user);
		removeMemberFromGroup(group1, unfollowing);
		em.persist(group);
		em.persist(group1);
	}

}
