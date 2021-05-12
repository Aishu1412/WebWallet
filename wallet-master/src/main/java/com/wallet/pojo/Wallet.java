package com.wallet.pojo;

public class Wallet {
	
	private int id;
	
	private Double cash;
	
	private String uid;
	
	public Wallet(){
		
	}

	public Wallet(int id, Double cash, String uid) {
		super();
		this.id = id;
		this.cash = cash;
		this.uid = uid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	

}
