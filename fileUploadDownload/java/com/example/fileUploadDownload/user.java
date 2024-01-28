package com.example.fileUploadDownload;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class user {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	private String Name;
	private int Age;
	private String City;
	
	
	
	
	public user(long ID, String name, int age,String city) {
		
		this.Id = ID;
		Name = name;
		this.Age = age;
		City = city;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return Id;
	}
	public void setId(long Id) {
		this.Id =Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	
	

}
