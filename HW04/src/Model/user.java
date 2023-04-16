package Model;

import java.io.Serializable;

public class user implements Serializable {
	private String username;
	
	public user(String username) {
		super();
		this.username = username;
	}

	public user() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
