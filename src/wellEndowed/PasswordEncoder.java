package wellEndowed;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.Stateless;

@Stateless
public class PasswordEncoder {
	public String encode(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashed = md.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
	        for(int i=0; i< hashed.length ;i++)
	        {
	            sb.append(Integer.toString((hashed[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("Can't find SHA-256 digest!");
		}
		
	}
}