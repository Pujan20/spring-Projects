package com.example.dbToExecelWithJdbc;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db")
public class Controller {
	@Autowired
	private Service serv;
	public Controller(Service serv) {
		this.serv=serv;
	}
	
	@GetMapping("/export")
	public String exportExcel() {
        try {
        	serv.exportDataToExcel();
            return "Excel exported successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error exporting Excel";
        }
    }
	

}
