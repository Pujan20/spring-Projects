package com.example.fileUploadDownload;


import java.io.IOException;
import java.sql.SQLException;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins="*")
public class UserController {

	 @Autowired
	    private UserService Service;

	    @PostMapping("/upload")
	    public ResponseEntity<String> uploadCSVFile(@RequestParam("file") MultipartFile file)throws SQLException {
	        try {
	            java.util.List<user> dataList =Service.readAndParseCSV(file);
	            Service.insertData(dataList);
	            return new ResponseEntity<>("File uploaded and data transferred successfully", HttpStatus.OK);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return new ResponseEntity<>("Error occurred while processing the file", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	    @GetMapping("/download")
		public String exportExcel() {
	        try {
	        	Service.exportDataToExcel();
	            return "Excel exported successfully!";
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "Error exporting Excel";
	        }
	    }
		
	    
	   
    }


