package wellEndowed;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.User;

@Stateless
@LocalBean
public class MemberService {
	
	@PersistenceContext(name="memberDataSource")
	private EntityManager em;
	
	public User getUser(String userName) {
		return em.find(User.class, userName);
	}

	public void updateUser(User u) {
		em.persist(u);
	}
	
	

}
