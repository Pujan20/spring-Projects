package com.example.FileStreaming;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DatabaseFileRepository {

    private final JdbcTemplate jdbcTemplate;
    
    public DatabaseFileRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFile(DatabaseFile databaseFile) {
        String query = "INSERT INTO files (id,fileName, fileType, data) VALUES (?,?, ?, ?)";
        jdbcTemplate.update(query, databaseFile.getId(),databaseFile.getFileName(), databaseFile.getFileType(), databaseFile.getData());
    }

    @SuppressWarnings("deprecation")
	public DatabaseFile findByFileName(String fileName) {
        String query = "SELECT * FROM files WHERE fileName = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{fileName}, (rs, rowNum) -> {
            DatabaseFile databaseFile = new DatabaseFile();
            databaseFile.setId(rs.getString("id"));
            databaseFile.setFileName(rs.getString("fileName"));
            databaseFile.setFileType(rs.getString("fileType"));
            databaseFile.setData(rs.getBytes("data"));
            return databaseFile;
        });
    }

    public List<String> getAllFileNames() {
        String query = "SELECT fileName FROM files";
        return jdbcTemplate.queryForList(query, String.class);
    }

    @SuppressWarnings("deprecation")
	public boolean existsByFileName(String fileName) {
        String query = "SELECT COUNT(*) FROM files WHERE fileName = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{fileName}, Integer.class) > 0;
    }
}
