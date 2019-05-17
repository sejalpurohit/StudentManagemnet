package com.data;

public class Teachers {

	private double Tid;
	private String name;
	private String username;
	private String password;
	private String action;
	

	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public double getTid() {
		return Tid;
	}
	public void setTid(double tid) {
		Tid = tid;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Teachers [Tid=" + Tid + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
