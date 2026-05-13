package com.demo.project.AI.service;
import com.demo.project.AI.entity.UploadedFile;
import com.demo.project.AI.repository.FileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {
	  @Autowired
	    private FileRepository repository;

	    public UploadedFile uploadFile(
	            MultipartFile file
	    ) throws IOException {

	        // uploads folder create
	    	String uploadDir =
	    	        System.getProperty("user.dir")
	    	        + File.separator
	    	        + "uploads"
	    	        + File.separator;
	        File folder = new File(uploadDir);

	        if(!folder.exists()){
	            folder.mkdirs();
	        }

	        // filename
	        String fileName =
	                file.getOriginalFilename();

	        // path
	        String filePath =
	                uploadDir + fileName;

	        // save file
	        file.transferTo(new File(filePath));

	        // save database
	        UploadedFile uploadedFile =
	                new UploadedFile();

	        uploadedFile.setFileName(fileName);

	        uploadedFile.setFileType(
	                file.getContentType()
	        );

	        uploadedFile.setFilePath(filePath);

	        return repository.save(uploadedFile);
	    }
}
