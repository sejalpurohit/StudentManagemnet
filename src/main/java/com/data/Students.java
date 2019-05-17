package com.data;

public class Students {
	
	private double id ;
	private String name;
	private double contact;
	private String email;
	private double physics;
	private double chemistry;
	private double maths;
	private double biology;
	private double total;
	private double percentage;
	private String grade;
	
	
	public double getId() {
		return id;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public double getPercentage() {
		return percentage;
	}


	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public void setId(double id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public double getContact() {
		return contact;
	}


	public void setContact(double contact) {
		this.contact = contact;
	}


	public double getPhysics() {
		return physics;
	}


	public void setPhysics(double physics) {
		this.physics = physics;
	}


	public double getChemistry() {
		return chemistry;
	}


	public void setChemistry(double chemistry) {
		this.chemistry = chemistry;
	}


	public double getMaths() {
		return maths;
	}


	public void setMaths(double maths) {
		this.maths = maths;
	}


	public double getBiology() {
		return biology;
	}


	public void setBiology(double biology) {
		this.biology = biology;
	}


	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", physics="
				+ physics + ", chemistry=" + chemistry + ", maths=" + maths + ", biology=" + biology + "]";
	}
	
}
