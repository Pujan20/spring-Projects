package com.example.webApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
            .antMatchers("/dashboard").authenticated() // Require authentication for the dashboard
            .anyRequest().permitAll() // Allow all other requests without authentication
            .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/dashboard") // Redirect to the dashboard upon successful login
            .permitAll()
            .and()
        .logout()
            .permitAll()
            .and()
        .csrf().disable(); // Disable CSRF for simplicity in this example
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");  // or specify your allowed origins explicitly
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
    
    

    // Override the authentication manager to use your custom logic
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
        // For simplicity, using in-memory authentication without password encoding
        auth.inMemoryAuthentication()
            .withUser("user1").password("password1").roles("USER")
            .and()
            .withUser("user2").password("password2").roles("USER");
    }
}
