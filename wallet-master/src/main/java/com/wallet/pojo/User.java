package com.wallet.pojo;

public class User {
	
	public User() {
		
	}
	
	
	public User(String username, String email, String password) {
		super();
		
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public User(String username, String email,String qrid, String password) {
		super();
		this.username = username;
		this.email = email;
		this.qrid = qrid;
		this.password = password;
	}



	
	private String username;
	
	private String email;
	
	private String password;
	
	private String qrid;



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getQrid() {
		return qrid;
	}


	public void setQrid(String qrid) {
		this.qrid = qrid;
	}
	
	

}
