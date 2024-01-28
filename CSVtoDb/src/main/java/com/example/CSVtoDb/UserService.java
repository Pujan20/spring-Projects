package com.example.CSVtoDb;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	private final UserRepo Repo;
	@Autowired
	 private final JdbcTemplate jdbcTemplate;
	 
	public UserService(UserRepo Repo,JdbcTemplate jdbcTemplate) {
		this.Repo=Repo;
		this.jdbcTemplate = new JdbcTemplate();
	}
   
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    

    @Transactional
    public void insertData(List<User> dataList) {
        for (User data : dataList) {
            jdbcTemplate.update(
                "INSERT INTO User(Id, Name, Age, City) VALUES (?, ?, ?, ?)",
                data.getId(), data.getName(), data.getAge(), data.getCity()
            );
        }
    }

    public List<User> readAndParseCSV(MultipartFile file) throws IOException {
        List<User> dataList = new ArrayList<>();
        
        
        DataType[] expectedDataTypes = {
            DataType.LONG, 
            DataType.STRING, 
            DataType.INTEGER, 
            DataType.STRING 
        };

        try (InputStreamReader reader = new InputStreamReader(file.getInputStream());
        	     CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
        	    boolean isFirstRecord = true;

        	    for (CSVRecord csvRecord : csvParser) {
        	        if (isFirstRecord) {
        	            isFirstRecord = false;
        	            continue;
        	        }
        	        
        	       

        	        User data = new User();
        	        boolean hasIncorrectType = false;

        	        for (int i = 0; i < 4; i++) {
        	            String cellValue = csvRecord.get(i);
        	            DataType expectedType = expectedDataTypes[i];

        	            if (cellValue == null || cellValue.isEmpty()) {
        	                
        	                hasIncorrectType = true;
        	                logger.warn("Skipping row with empty cell at column " + (i + 1) + " data values " + csvRecord.toString());
        	                break; 
        	            }

        	            if (!isValidDataType(cellValue, expectedType)) {
        	                hasIncorrectType = true;
        	                logger.warn("Skipping row with incorrect data type at column " + (i + 1) + " data values " + csvRecord.toString());
        	                break; 
        	            }

        	            switch (i) {
        	                case 0:
        	                    data.setId(Long.parseLong(cellValue));
        	                    break;
        	                case 1:
        	                    data.setName(cellValue);
        	                    break;
        	                case 2:
        	                    data.setAge(Integer.parseInt(cellValue));
        	                    break;
        	                case 3:
        	                    data.setCity(cellValue);
        	                    break;
        	            }
        	        }

        	      
        	        if (hasIncorrectType) {
        	            continue;
        	        }

        	        dataList.add(data);
        	    }
        	}

        	return dataList;

    }
    
    private boolean isValidDataType(String cellValue, DataType expectedType) {
        try {
            switch (expectedType) {
                case LONG:
                    Long.parseLong(cellValue);
                    break;
                case INTEGER:
                    Integer.parseInt(cellValue);
                    break;
                case STRING:
                  
                    break;
                
            }
            return true;
        } catch (NumberFormatException | DateTimeParseException e) {
            return false;
        }
    }

    enum DataType {
        LONG, INTEGER, STRING
    }
    
    
  
}
