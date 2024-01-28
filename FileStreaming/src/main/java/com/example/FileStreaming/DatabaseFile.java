package com.example.FileStreaming;

import java.util.Arrays;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;


@Entity
@Table(name="files")
public class DatabaseFile {
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",strategy="uuid2")
	private String id;
	
	private String fileName;
	private String fileType;
	
	@Lob
	private byte[] data;
	
	public DatabaseFile() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public DatabaseFile(String id, String fileName, String fileType, byte[] data) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	@Override
	public String toString() {
		return "DatabaseFile [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", data="
				+ Arrays.toString(data) + "]";
	}

	public String getFileType() {
		return fileType;
	}


	public DatabaseFile orElseThrow(Object object) {
		 if (object == null) {
		        throw new IllegalArgumentException("error in execution");
		    }
		    return (DatabaseFile) object;
	}

	

	
	
	
	

}
