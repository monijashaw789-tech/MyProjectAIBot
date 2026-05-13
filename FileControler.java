package com.demo.project.AI.controller;
import com.demo.project.AI.entity.UploadedFile;
import com.demo.project.AI.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
@CrossOrigin("*")
public class FileControler {
	  @Autowired
	    private FileService service;

	    @PostMapping("/upload")
	    public ResponseEntity<UploadedFile>
	    uploadFile(

	        @RequestParam("file")
	        MultipartFile file

	    ) throws Exception {

	        UploadedFile uploadedFile =
	                service.uploadFile(file);

	        return ResponseEntity.ok(uploadedFile);
}
}
