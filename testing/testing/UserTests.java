package testing;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import models.User;

import org.junit.Test;

import wellEndowed.MemberService;

public class UserTests {

	@Test
	public void test() throws NamingException {
		final Properties p = new Properties();
		 p.put("reactionDistractionDataSource", "new://Resource?type=DataSource");
		 p.put("reactionDistractionDataSource.JdbcDriver","org.hsqldb.jdbcDriver");
		 p.put("reactionDistractionDataSource.JdbcUrl","jdbc:hsqldb:mem:reactionDistraction");
		 
		final Context context = EJBContainer.createEJBContainer(p).getContext();

		MemberService ms = (MemberService) context.lookup("java:global/Java II Lab/MemberService");
		
		User user = new User("Rachel", "Antion", "rantion");
		User user1 = new User("Luis", "Heinecke", "lheinecke");
		User user2 = new User("Daniel","Morroquin", "dmorroquin");
		User user3 = new User("Tyler", "Howes", "thowes");
		System.out.println("adding Users");
		ms.addUser(user);
		ms.addUser(user1);
		ms.addUser(user2);
		ms.addUser(user3);
		List<User> users = ms.getUsers();
		for(User _user : users){
			System.out.println(_user);
		}
		
		assertEquals(ms.getUser("rantion"), user);
	}

}
