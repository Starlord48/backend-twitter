package com.twitter.responce;


public class AuthResponce {
	
	private String jwt;
	private boolean status;
	
	public AuthResponce() {
		super();
	}
	public AuthResponce(String jwt, boolean status) {
		super();
		this.jwt = jwt;
		this.status = status;
	}
	
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
