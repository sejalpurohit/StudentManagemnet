package com.data;

public class LoginChoice {
	private String choice;
	private String userName;
	private String password;

	

	public String getChoice() {
		return choice;
	}



	public void setChoice(String choice) {
		this.choice = choice;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "LoginChoice [choice=" + choice + ", userName=" + userName + ", password=" + password + "]";
	}


}
