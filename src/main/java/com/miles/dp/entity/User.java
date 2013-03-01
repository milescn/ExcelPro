package com.miles.dp.entity;

public class User { 
	private String name; 
	private String password; 
	private String email;
	private int age; 
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String toString() { 
		return "Name:" + name + "\n" + "Password:" + password + "\n" + "Email:" + email + "\n" + "Age:" + age;
	}
}