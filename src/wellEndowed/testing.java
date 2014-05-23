package wellEndowed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import models.*;

public class testing {

	public static void main(String[]args){
		User rachel = new User("Rachel", "Antion", "rantion");
		User luis = new User("Luis", "H","LuisH");
		User daniel = new User ("Daniel", "M", "DanielM");
		
		rachel.follow(luis);
		daniel.follow(luis);
		luis.follow(rachel);
//		HashMap<String, User> followers = luis.getFollowers().getGroup();
//		Iterator it = followers.entrySet().iterator();
//		while(it.hasNext()){
//			Map.Entry<String, User> pair = (Map.Entry<String, User>)it.next();
//			System.out.println(pair.getValue());
//		}
		
//		HashMap<String, User> following = luis.getFollowing().getGroup();
//		System.out.println("\nLuis is Following: ");
//		Iterator itt = following.entrySet().iterator();
//		while(itt.hasNext()){
//			Map.Entry<String, User> pair = (Map.Entry<String, User>)itt.next();
//			System.out.println(pair.getValue());
//		}
		
		List<User> users = new ArrayList<User>(Arrays.asList(luis,daniel));
		
		rachel.createNewGroup("BITCHES", users);
		Group bitches = rachel.getGroup("BITCHES");
		
		HashMap<String, User> _bitches = bitches.getGroup();
		System.out.println("\nRachel's Bitches: ");
		Iterator itt = _bitches.entrySet().iterator();
		while(itt.hasNext()){
			Map.Entry<String, User> pair = (Map.Entry<String, User>)itt.next();
			System.out.println(pair.getValue());
		}
		
		bitches.removeMember(daniel);
		
		HashMap<String, User> bitchess = bitches.getGroup();
		System.out.println("\nRachel's Bitches: ");
		Iterator ittt = bitchess.entrySet().iterator();
		while(ittt.hasNext()){
			Map.Entry<String, User> pair = (Map.Entry<String, User>)ittt.next();
			System.out.println(pair.getValue());
		}
		
//		rachel.removeGroup("BITCHES");
//		
//		Group bitchess = rachel.getGroup("BITCHES");
//		System.out.println("\nRachel's Bitches: ");
//		if(bitchess ==null){
//			System.out.println("BITCHES  don't exist.");
//		}
//		}
//		
//		List<User> userss = new ArrayList<User>(Arrays.asList(daniel));
//		luis.startMessageChat(userss,"helloBeeeetches.");
//		
//		System.out.println("Luis' inbox: ");
//		List<MessageChat> luiss = luis.getMessages();
//		for(MessageChat messageChat: luiss){
//			for(Message chat: messageChat.getMessages()){
//				System.out.println(chat);
//			}
//		}
//		
//		System.out.println("Daniels' inbox: ");
//		List<MessageChat> daniels = daniel.getMessages();
//		for(MessageChat messageChat: daniels){
//			for(Message chat: messageChat.getMessages()){
//				System.out.println(chat);
//			}
//		}		
//		
//		
//		System.out.println("Rachel's inbox: ");
//		List<MessageChat> rachels = rachel.getMessages();
//		for(MessageChat messageChat: rachels){
//			for(Message chat: messageChat.getMessages()){
//				System.out.println(chat);
//			}
//		}

	}
	
}
