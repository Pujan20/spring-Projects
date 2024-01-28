package com.example.webApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
    private UserService userService;
	
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    
//    @Autowired
//    public userController(UserService userService) {
//        this.userService = userService;
//        }

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticateUser(@RequestBody userCredentials request) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = userService.loadUserByUsername(request.getUsername());

            // Check the password without encoding (not recommended for production)
            if (request.getPassword().equals(userDetails.getPassword())) {
                logger.info("Authentication successful for user: {}", userDetails.getUsername());
                return ResponseEntity.ok(Map.of("message", "Authentication successful!"));
            } else {
                logger.warn("Authentication failed for user: {}", userDetails.getUsername());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("error", "Authentication failed. Incorrect password."));
            }
        } catch (UsernameNotFoundException e) {
            logger.warn("Authentication failed. User not found: {}", request.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Authentication failed."));
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "redirect:/submit"; // Assuming "login" is the name of your login page template or view
    }

    
    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "dashboard"; // Assuming "dashboard" is the name of your dashboard page template or view
    }

    @PostMapping("/submit")
    public ResponseEntity<Map<String, String>> submitForm(@RequestBody DashboardData dashboardData) {
        try {
            // Perform any business logic/validation if needed

            // Save data to the database
            userService.saveDashboardData(dashboardData);

            // Return a JSON response
            Map<String, String> response = new HashMap<>();
            response.put("message", "Form submitted successfully!");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Return an error JSON response
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error submitting form: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
   

