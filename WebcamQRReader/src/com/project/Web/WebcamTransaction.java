package com.project.Web;

import java.util.Date;

public class WebcamTransaction {


	private int id;
	
	private double amount;
	
	private String comments;
	
	private Date time;
	
	private String user;

	
	public WebcamTransaction(double cash, String comments) {
		// TODO Auto-generated constructor stub
	}

	

	public WebcamTransaction(int id, double amount, String comments, Date time, String user) {
		super();
		this.id = id;
		this.amount = amount;
		this.comments = comments;
		this.time = time;
		this.user = user;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}



}
