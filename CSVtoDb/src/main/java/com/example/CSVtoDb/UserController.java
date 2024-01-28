package com.example.CSVtoDb;


import java.io.IOException;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequestMapping("/file")
public class UserController {

	 @Autowired
	    private UserService Service;

	    @PostMapping("/upload")
	    public ResponseEntity<String> uploadCSVFile(@RequestParam("file") MultipartFile file) {
	        try {
	            java.util.List<User> dataList =Service.readAndParseCSV(file);
	            Service.insertData(dataList);
	            return new ResponseEntity<>("File uploaded and data transferred successfully", HttpStatus.OK);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return new ResponseEntity<>("Error occurred while processing the file", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	   
		
	    
	   
    }


