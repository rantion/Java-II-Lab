package wellEndowed;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.Role;
import models.User;

@Stateless
@LocalBean
public class MemberService {
	
	@PersistenceContext(name="reactionDistractionUnit")
	private EntityManager em;
	
	public User getUser(String userName) {
		Query q = em.createQuery("select u from User u where u.username = '"+userName+"'");
		return (User)q.getSingleResult();
	}
	
	public void addUser(User u){
		em.persist(u);
	}

	public void updateUser(User u) {
		
		if(!u.hasRole(Role.USER))
		{
			u.addRole(Role.USER);
		}
		
		em.persist(u);
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
