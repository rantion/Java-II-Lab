package wellEndowed;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.Message;
import models.MessageChat;
import models.User;

@Stateless
@LocalBean
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
	
	public void removeAllMessageChats(){
		List<MessageChat> messageChats = getMessageChats();
		for(MessageChat messagechat : messageChats){
			em.remove(messagechat);
		}
	}
	
	public void startMessageChat(User messageStarter,String messageContent, User...members) {
		MessageChat messageChat = new MessageChat();
		for(User user: members){
			user = em.merge(user);
			messageChat.addChatUser(user);
			user.addMessageChat(messageChat);
		}
		messageStarter = em.merge(messageStarter);
		
		messageChat.addChatUser(messageStarter);
		messageStarter.addMessageChat(messageChat);
		
		Message message = new Message(messageStarter, messageContent);
		message.setMessageChat(messageChat);
		messageChat.addMessage(message);
		em.persist(messageChat);
		
	}
	
	public void addMessageToMessageChat(MessageChat messagechat, Message message){
		messagechat.addMessage(message);
		em.persist(em.merge(messagechat));
	}


}