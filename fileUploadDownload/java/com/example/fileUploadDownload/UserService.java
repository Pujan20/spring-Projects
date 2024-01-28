package com.example.fileUploadDownload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public void insertData(List<user> dataList) throws SQLException {
        
        	for (user data : dataList) {
			    jdbcTemplate.update(
			        "INSERT INTO User( Name, Age, City) VALUES ( ?, ?, ?)",
			         data.getName(), data.getAge(), data.getCity()
			    );
			}
        
    }

    public List<user> readAndParseCSV(MultipartFile file) throws IOException {
        List<user> dataList = new ArrayList<>();
        
        
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
        	        
        	       

        	        user data = new user();
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
    

    public List<user> exportDataToExcel() throws IOException {
    	 List<user> people = Repo.findAll();

         Workbook workbook = WorkbookFactory.create(true);
         org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("People");

         
         Row headerRow = sheet.createRow(0);
         headerRow.createCell(0).setCellValue("id");
         headerRow.createCell(1).setCellValue("Name");
         headerRow.createCell(2).setCellValue("Age");
         headerRow.createCell(3).setCellValue("City");

         
         int rowNum = 1;
         for (user person : people) {
             Row row = sheet.createRow(rowNum++);
             row.createCell(0).setCellValue(person.getId());
             row.createCell(1).setCellValue(person.getName());
             row.createCell(2).setCellValue(person.getAge());
             row.createCell(3).setCellValue(person.getCity());
         }

       
         try (FileOutputStream fileOut = new FileOutputStream("DbToEx.xlsx")) {
             workbook.write(fileOut);
         }

        
         workbook.close();
		return people;
		}

    
    
  
}
