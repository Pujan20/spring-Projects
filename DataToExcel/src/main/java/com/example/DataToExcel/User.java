package com.example.DataToExcel;

@jakarta.persistence.Entity
public class User {
	@jakarta.persistence.Id
	private Long id;
	private String Name;
	private int Age;
	private String City;
	public User(Long id, String name, int age, String city) {
		super();
		this.id = id;
		Name = name;
		Age = age;
		City = city;
	}
	public User() {
		super();
		
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Name=" + Name + ", Age=" + Age + ", City=" + City + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
