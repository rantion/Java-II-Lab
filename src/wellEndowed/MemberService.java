package wellEndowed;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.User;

@Stateless
@LocalBean
public class MemberService {
	
	@PersistenceContext(name="reactionDistractionUnit")
	private EntityManager em;
	
	public User getUser(String userName) {
		return em.find(User.class, userName);
	}
	
	public void addUser(User u){
		em.persist(u);
	}

	public void updateUser(User u) {
		em.persist(u);
	}
	
	public List<User> getUsers(){
		Query q = em.createQuery("select * from User");
		return q.getResultList();
	}
	

}
