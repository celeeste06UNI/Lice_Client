package com.mkyong.web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mkyong.users.service.DatamodelService;
import com.mkyong.users.service.PersonalService;

@Controller
public class FileUploadController {
	public static String uploadDirectory = System.getProperty("user.home") + "/upload";
	@Autowired
	private DatamodelService datamodelService;

	@RequestMapping("main/viewUpload")
	public String UploadPage(Model model) {
		return "uploadview";
	}

	@RequestMapping("/upload")
	public String upload(@RequestParam("files") MultipartFile[] files) {
		StringBuilder fileNames = new StringBuilder();
		
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename() + " ");
			try {
				Files.write(fileNameAndPath, file.getBytes());
				datamodelService.upload(fileNameAndPath.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "main";
	}

}
