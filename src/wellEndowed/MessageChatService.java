package wellEndowed;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.Message;
import models.MessageChat;
import models.User;

@Stateless
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
	
	public List<MessageChat> getMessageChats(){
		return em.createQuery("Select i FROM MessageChat i").getResultList();
	}
	
	public void startMessageChat(User messageStarter,String messageContent, User...members) {
		List<User> users = new ArrayList<User>();
		for(User user: members){
			user = em.merge(user);
			users.add(user);
		}
		users.add(em.merge(messageStarter));
		MessageChat messageChat = new MessageChat(users);
		Message message = new Message(messageStarter, messageContent);
		em.persist(message);	
		messageChat.addMessage(message);
		messageChat.setChatUsers(users);
		em.persist(messageChat);
		for(User _user: users){
			_user.addMessageChat(messageChat);
		}
	} 


}
