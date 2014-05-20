package models;

import java.security.Principal;

public class CurrentUser {
	private static final ThreadLocal<Principal> userStorage = new ThreadLocal<Principal>();
	
	public static Principal getUser() {
		return userStorage.get();
	}
	
	public static void setUser(Principal p) {
		userStorage.set(p);
	}
}
