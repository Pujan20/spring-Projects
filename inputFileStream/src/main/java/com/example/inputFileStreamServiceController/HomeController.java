package com.example.inputFileStreamServiceController;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.inputFileStreamService.UploadDownloadService;

import jakarta.annotation.Resource;

@RestController
public class HomeController {
	
	private static final String path="/home/corpository/Downloads/DbToExecel/";
	
	@Autowired
	UploadDownloadService serv;
	public HomeController(UploadDownloadService serv) {
		this.serv=serv;
	}

	@PostMapping("/upload")
	 public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file) {
        try {
            List<String> result = serv.UploadFile(file);
           
            String resultString = String.join(", ", result);
            return new ResponseEntity<>(resultString, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to upload the file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	@RequestMapping(path="/download",method=RequestMethod.GET)
	 @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> download(@RequestParam String param) throws IOException {
        File file = new File(path + param);
        Path filePath = Paths.get(file.getAbsolutePath());
        
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(filePath));
        
       HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + param);
        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        headers.add(HttpHeaders.PRAGMA, "no-cache");
        headers.add(HttpHeaders.EXPIRES, "0");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
	
	@GetMapping("/list")
    public ResponseEntity<?> getListOfFiles() {
        try {
            List<String> files = (List<String>) serv.getListofFiles();
            return new ResponseEntity<>(files, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve the list of files: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
