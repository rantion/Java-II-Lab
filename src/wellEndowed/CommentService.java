package wellEndowed;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.Comment;
@Stateless
@LocalBean
public class CommentService {

	@PersistenceContext(name="reactionDistractionUnit")
	private EntityManager em;
	
	public void addComment(Comment comment){
		em.persist(comment);
	}

	public void updateCommet(Comment comment){
		em.persist(comment);
	}
	
	public Comment getMessageChat(int commentNum) {
		return em.find(Comment.class, commentNum);
	}
}
