package com.example.webApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserCredRepo {

	@Autowired
    private  JdbcTemplate jdbcTemplate;

//    @Autowired
//    public UserCredRepo(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    @SuppressWarnings("deprecation")
	public userCredentials findByUsername(String username) {
        try{String sql = "SELECT * FROM userCredentials WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, (resultSet, rowNum) ->
                new userCredentials(
                        resultSet.getString("username"),
                        resultSet.getString("password")
                )
        );
    }catch (EmptyResultDataAccessException e) {
        // Handle the case where no user with the specified username is found.
        return null; // Or throw an exception, or return a special value indicating not found.
    }
}

    public void saveDashboardData(DashboardData dashboardData) {
        String sql = "INSERT INTO dashboard_data (first_name, last_name, email, phone) " +
                     "VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql,
        		
                dashboardData.getFirstName(),
                dashboardData.getLastName(),
                dashboardData.getEmail(),
                dashboardData.getPhone());
    }
}
