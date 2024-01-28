package com.example.dbToExecelWithJdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

@org.springframework.stereotype.Repository
public class Repository {
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public Repository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	 public List<User> findAll() {
	        String sql = "SELECT * FROM User";
	        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
	    }
	
}
