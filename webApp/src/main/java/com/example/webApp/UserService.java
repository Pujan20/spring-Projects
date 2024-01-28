package com.example.webApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

	@Autowired
    private UserCredRepo userRepo;

//    @Autowired
//    public UserService(UserCredRepo userRepo) {
//        this.userRepo = userRepo;
//    }

	public boolean checkPasswordByUsername(String username, String enteredPassword) {
	    userCredentials userCredentials = userRepo.findByUsername(username);

	    if (userCredentials != null) {
	        String storedPassword = userCredentials.getPassword();

	        // Check if the entered password matches the stored password
	        return storedPassword.equals(enteredPassword);
	    } else {
	        // Handle the case where the username is not found
	        return false; // or throw an exception, or return a default value
	    }
	}

    public void saveDashboardData(DashboardData dashboardData) throws Exception {
        try {
            // Perform any business logic/validation if needed

            // Save data to the database using the correct repository method
            userRepo.saveDashboardData(dashboardData);

        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception or log it
            throw new Exception("Error saving dashboard data", e);
        }
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
