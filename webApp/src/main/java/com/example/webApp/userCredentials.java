package com.example.webApp;

import java.util.Collection;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name="userCredentials")
public class userCredentials {

    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    // Constructors, getters, and setters

    public userCredentials() {
        // Default constructor required by JPA
    }

    public userCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

	
	public userCredentials orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	
}
