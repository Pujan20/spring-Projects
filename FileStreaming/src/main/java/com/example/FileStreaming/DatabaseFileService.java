package com.example.FileStreaming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class DatabaseFileService {

    @Autowired
    private DatabaseFileRepository repository;

    public void storeFile(MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        String fileType = file.getContentType();
        byte[] data = file.getBytes();

      
			if (repository.existsByFileName(fileName)) {
			    throw new ExceptionAlreadyExist("File with the same name already exists: " + fileName);
			}


			DatabaseFile databaseFile = new DatabaseFile();
			databaseFile.setFileName(fileName);
			databaseFile.setFileType(fileType);
			databaseFile.setData(data);

			repository.saveFile(databaseFile);
		
    }


    public DatabaseFile getFileByName(String fileName) {
        return repository.findByFileName(fileName);
    }

    public List<String> getAllFileNames() {
        return repository.getAllFileNames();
    }
}


