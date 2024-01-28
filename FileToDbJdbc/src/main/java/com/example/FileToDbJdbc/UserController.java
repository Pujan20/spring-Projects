package com.example.FileToDbJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/create")
    public void createTable() {
        userService.Create();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCSVFile(@RequestParam("file") MultipartFile file) {
        userService.insertDataFromCsv(file); // Use service method to process the file
        return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test() {
        return "Good testing";
    }
}
