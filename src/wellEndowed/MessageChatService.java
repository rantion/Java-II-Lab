package wellEndowed;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.MessageChat;

public class MessageChatService {
	
	@PersistenceContext(name="reactionDistractionUnit")
	private EntityManager em;
	
	public void addMessageChat(MessageChat message){
		em.persist(message);
	}

	public void updateMessage(MessageChat message){
		em.persist(message);
	}
	
	public MessageChat getMessageChat(int messageNum) {
		return em.find(MessageChat.class, messageNum);
	}


}
