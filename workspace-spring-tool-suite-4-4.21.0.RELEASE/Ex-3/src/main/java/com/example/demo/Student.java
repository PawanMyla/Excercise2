package com.example.demo;

public class Student {
	
	private String name;
	private String fatherNama;
	private String dob;
	private String gender;
	
	
	
	public Student(String name, String fatherNama, String dob, String gender) {
		
		this.name = name;
		this.fatherNama = fatherNama;
		this.dob = dob;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherNama() {
		return fatherNama;
	}
	public void setFatherNama(String fatherNama) {
		this.fatherNama = fatherNama;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
