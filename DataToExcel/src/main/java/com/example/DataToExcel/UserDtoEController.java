package com.example.DataToExcel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/export")
public class UserDtoEController {
    private final UserServ userService;

    public UserDtoEController(UserServ userService) {
        this.userService = userService;
    }

    @GetMapping("/toexcel")
    public ResponseEntity<String> exportToExcel() {
        try {
            userService.exportDataToExcel();
            return new ResponseEntity<>("Data exported to Excel successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error exporting data to Excel", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
