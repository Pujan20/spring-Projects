package com.example.FileToDbJdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl {
    
    private  JdbcTemplate jdbcTemplate;

    @Autowired
    public UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void insertDataFromCsv(MultipartFile csvFile) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(csvFile.getInputStream(), "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT
                     .withFirstRecordAsHeader()
                     .withIgnoreHeaderCase()
                     .withTrim())) {

            List<User> users = new ArrayList<>();
            for (CSVRecord csvRecord : csvParser) {
                int id = Integer.parseInt(csvRecord.get("id"));
                String name = csvRecord.get("Name");
                int age = Integer.parseInt(csvRecord.get("Age"));
                String city = csvRecord.get("City");

                // Insert data into the database directly using JdbcTemplate
                jdbcTemplate.update(
                    "INSERT INTO user(id, Name, Age, City) VALUES (?, ?, ?, ?)",
                    id, name, age, city
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., log it or throw a custom exception)
        }
    }
    
    public static void Create() {
		
  		 String sql = "Create table user(id int PRIMARY KEY,Name VARCHAR(255) NOT NULL,Age INT NOT NULL,City VARCHAR(255) NOT NULL)";
  	        
  		
  		
  		try {
			JdbcTemplate jdbcTemplate2 = new JdbcTemplate();
			jdbcTemplate2.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	   
  	}
        
    }
    
  
 




	
	
