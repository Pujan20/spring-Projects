package com.example.FileToDbJdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.FileToDbJdbc")
public class FileToDbJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileToDbJdbcApplication.class, args);
	}

}
