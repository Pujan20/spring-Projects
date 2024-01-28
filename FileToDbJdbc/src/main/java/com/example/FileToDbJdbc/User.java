package com.example.FileToDbJdbc;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String Name;
	private int Age;
	private String City;
	
	
	public User(int id, String name, int Age, String city) {
		
		this.id = id;
		Name = name;
		this.Age = Age;
		City = city;
	}
	
	
	public User() {
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
