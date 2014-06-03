package wellEndowed;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.Post;
@Stateless
@LocalBean
public class PostService {
	
	@PersistenceContext(name="reactionDistractionUnit")
	private EntityManager em;
	
	public void addPost(Post post){
		em.persist(post);
	}

	public void updateMessage(Post post){
		em.persist(post);
	}
	
	public List<Post> getPostsOnPost(Post post){
		return em.createNamedQuery("postsByPost").setParameter("post", post).getResultList();
	}
	
	public Post getPost(int postNum) {
		return em.find(Post.class, postNum);
	}
}
