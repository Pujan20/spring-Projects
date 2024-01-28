package com.example.fileUploadDownload;


import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class UserRepo {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<user> findAll() {
        String sql = "SELECT * FROM User";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(user.class));
    }

}

     


