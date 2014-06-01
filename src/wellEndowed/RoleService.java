package wellEndowed;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.Role;

@Stateless
@LocalBean
public class RoleService 
{
	@PersistenceContext(name="reactionDistractionUnit")
	private EntityManager em;
	
	public Role getRoleOfUser(String userName)
	{
		return em.createNamedQuery("getRoleOfUser", Role.class)
				.setParameter("username", userName).getSingleResult();
	}
}