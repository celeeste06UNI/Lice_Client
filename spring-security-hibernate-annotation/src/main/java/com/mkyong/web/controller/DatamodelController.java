package com.mkyong.web.controller;

import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class DatamodelController {
	
    private static String filePath = System.getProperty("catalina.home") 
    		+ File.separator + "webapps"+File.separator+"images"+File.separator; 
	
	@RequestMapping(value = "main/viewUploadXml", method = RequestMethod.GET)
	public String viewEmployee() {
		return "viewUploadXml";
	}
	
    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile image) { 
        
        if(!image.isEmpty()) {
            try {
                image.transferTo(new File(filePath+image.getOriginalFilename()));                
            } catch(Exception e) {
                                
            }
        }        
        return "main";
    }

}
