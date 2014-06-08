package wellEndowed;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.Message;
import models.User;

@Stateless
@LocalBean
public class MessageService {

	@PersistenceContext(name = "reactionDistractionUnit")
	private EntityManager em;

	public void addMessage(Message message) {
		em.persist(message);
	}

	public void updateMessage(Message message) {
		em.persist(message);
	}

	public Message getMessage(int messageNum) {
		return em.find(Message.class, messageNum);
	}

	public List<Message> getMessages() {
		return em.createQuery("SELECT m FROM Message m").getResultList();
	}

	public void removeAllMessages() {
		List<Message> messages = getMessages();
		for (Message message : messages) {
			em.remove(message);
		}
	}
}
