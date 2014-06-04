package wellEndowed;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.Message;
import models.MessageChat;
import models.User;

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
	
	@TransactionAttribute
	public void startMessageChat(User messageStarter,String messageContent, User...members) {
		List<User> users = new ArrayList<User>();
		for(User user: members){
			users.add(user);
		}
		MessageChat messageChat = new MessageChat(users);
		Message message = new Message(messageStarter, messageContent);
		em.persist(message);
		messageChat.addMessage(message);
		this.addMessageChat(messageChat);
		em.persist(messageChat);
		em.persist(messageStarter);
		for(User user: users){
			em.persist(user);
		}
	}


}
