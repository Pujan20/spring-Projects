package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SdRepoImpl implements SdRepo {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SdRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int Create(Sdetails S) {
        String sql = "INSERT INTO Sdetails (id, Sname, result, maths, science, english, Remarks, Division) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        return jdbcTemplate.update(sql, S.getId(), S.getSname(), S.getResult(), S.getMaths(), S.getScience(), S.getEnglish(), S.getRemarks(), S.getDivision());
    }

    @Override
    public int Update(Sdetails S, int id) {
        String sql = "UPDATE Sdetails SET Sname = ?, result = ?, maths = ?, science = ?, english = ?, Remarks = ?, Division = ? WHERE id = ?";
        return jdbcTemplate.update(sql, S.getSname(), S.getResult(), S.getMaths(), S.getScience(), S.getEnglish(), S.getRemarks(), S.getDivision(), id);
    }

    @Override
    public List<Sdetails> FindById(int id) {
        String sql = "SELECT * FROM Sdetails WHERE id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Sdetails.class), id);
    }

    @Override
    public List<Sdetails> ShowAll() {
        String sql = "SELECT * FROM Sdetails";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Sdetails.class));
    }
}



