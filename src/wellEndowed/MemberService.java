package wellEndowed;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.Group;
import models.User;

@Stateless
@LocalBean
public class MemberService {
	
	@PersistenceContext(name="reactionDistractionUnit")
	private EntityManager em;
	@Inject GroupService gs;
	
	public User getUser(String userName) {
		Query q = em.createQuery("select u from User u where u.userName = '"+userName+"'");
		return (User)q.getSingleResult();
	}
	
	public void addUser(User u){
		Group followers = new Group(u, u.getUserName() + "FOLLOWERS");
		Group following = new Group(u, u.getUserName() + "FOLLOWING");
		em.persist(following);
		em.persist(followers);
		em.persist(u);
	}

	public void updateUser(User u) {
		em.persist(u);
	}
	
	public void addFollower(User user, User follower){
		
	}
	
	public void startFollowing(User user, User following){
	if(gs.getGroup(following,following.getUserName()+"FOLLOWERS")!=null){
		gs.createNewGroup(following,following.getUserName()+"FOLLOWERS", user);
	}
	}
	
	public List<User> getUsers(){
		Query q = em.createQuery("select u from User u");
		return q.getResultList();
	}
	
	public void deleteUsers(){
		List<User> users = getUsers();
		for(User user: users){
			em.remove(user);
		}
	}
	

}
