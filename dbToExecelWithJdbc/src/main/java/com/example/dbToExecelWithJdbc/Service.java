package com.example.dbToExecelWithJdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository Repo;
    
    public Service(Repository Repo) {
		this.Repo=Repo;
	}
    

    
    public List<User> exportDataToExcel() throws IOException {
    	 List<User> people = Repo.findAll();

         Workbook workbook = WorkbookFactory.create(true);
         org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("People");

         
         Row headerRow = sheet.createRow(0);
         headerRow.createCell(0).setCellValue("id");
         headerRow.createCell(1).setCellValue("Name");
         headerRow.createCell(2).setCellValue("Age");
         headerRow.createCell(3).setCellValue("City");

         
         int rowNum = 1;
         for (User person : people) {
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
