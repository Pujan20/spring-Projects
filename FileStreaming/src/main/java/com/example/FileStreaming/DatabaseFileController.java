package com.example.FileStreaming;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class DatabaseFileController {

    @Autowired
    private DatabaseFileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> FileUpload(@RequestParam("file") MultipartFile file) throws Exception {
    	if (file != null) {
    	    try {
    	        fileService.storeFile(file);
    	        return ResponseEntity.ok("File uploaded successfully");
    	    } catch (IOException e) {
    	       
    	        e.printStackTrace();
    	        return ResponseEntity.status(500).body("Failed to upload file: " + e.getMessage());
    	    }
    	} else {
    	} return ResponseEntity.badRequest().body("File is null");
    	}

    @GetMapping("/list")
    public ResponseEntity<List<String>> listFiles() {
        List<String> fileList = fileService.getAllFileNames();
        return ResponseEntity.ok(fileList);
    }

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) {
        DatabaseFile file = fileService.getFileByName(fileName);

        if (file != null) {
            try {
                byte[] fileData = file.getData();

               
                HttpHeaders headers = new HttpHeaders();
                headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getFileName()).build());
                headers.setContentType(MediaType.parseMediaType(file.getFileType()));

               
                return ResponseEntity.ok()
                        .headers(headers)
                        .body(fileData);
            } catch (Exception e) {
                               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    }


