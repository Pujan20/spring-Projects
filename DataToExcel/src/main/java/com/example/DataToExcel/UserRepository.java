package com.example.DataToExcel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll(){
       
        String sql = "SELECT id, Name, Age, City FROM User";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("Name"));
            user.setAge(rs.getInt("Age"));
            user.setCity(rs.getString("City"));
            return user;
        });
    }
}

