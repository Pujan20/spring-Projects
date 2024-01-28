package com.Date.DateDemo;

import java.time.LocalDate;

import java.time.Period;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DateController {

	@GetMapping
	@RequestMapping("/checkDate/{date}")
    public String checkDate(@PathVariable String date ){
        LocalDate currentDate = LocalDate.now();
        LocalDate inputDate = LocalDate.parse(date);
        Period period = Period.between(currentDate, inputDate);
        
        if (period.isNegative()) {
            return "The Date "+inputDate+" is no more valid";
        } else {
        	return "date is valid";
        }
	}
        @GetMapping("/test")
        public String test() {
        	return "Hello World";
        }

}
