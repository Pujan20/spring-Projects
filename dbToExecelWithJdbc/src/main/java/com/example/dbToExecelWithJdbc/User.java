package com.example.dbToExecelWithJdbc;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	private int Id;
	private String Name;
	private int Age;
	private String City;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, int age, String city) {
		super();
		Id = id;
		Name = name;
		Age = age;
		City = city;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	@Override
	public String toString() {
		return "User [Id=" + Id + ", Name=" + Name + ", Age=" + Age + ", City=" + City + "]";
	}
	
	

}
