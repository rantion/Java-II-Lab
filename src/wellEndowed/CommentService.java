package wellEndowed;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.Comment;
import models.Group;
import models.Post;
@Stateless
@LocalBean
public class CommentService {

	@PersistenceContext(name="reactionDistractionUnit")
	private EntityManager em;
	
	public void addComment(Comment comment){
		em.persist(comment);
	}

	
	public Comment getComment(int id){
	return (Comment) em.createNamedQuery("byCommentNum")
				.setParameter("commentId", id).getSingleResult();
	}
	
	public List<Comment> getCommentsByPost(Post post){
		return em.createNamedQuery("byPost").setParameter("post", post).getResultList();
	}
	
	public List<Comment> getCommentsByComment(Comment comment){
		return em.createNamedQuery("byComment").setParameter("comment", comment).getResultList();
	}

	public void updateCommet(Comment comment){
		em.persist(comment);
	}

}
