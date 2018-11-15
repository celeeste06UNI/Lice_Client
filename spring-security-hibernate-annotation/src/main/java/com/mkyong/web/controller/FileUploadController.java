package com.mkyong.web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.users.model.DataModel;
import com.mkyong.users.model.DataModelDecript;
import com.mkyong.users.model.Organization;
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
	public String upload(@RequestParam("files") MultipartFile[] files, @RequestParam("sistemabbdd") String sistemabbdd,
			@RequestParam("version") String version) {
		
		
		StringBuilder fileNames = new StringBuilder();
		
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename() + " ");
			try {
				Files.write(fileNameAndPath, file.getBytes());
				datamodelService.upload(fileNameAndPath.toString(), sistemabbdd, version);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "main";
	}
	
	@RequestMapping(value = "main/viewDatamodel", method = RequestMethod.GET)
	public ModelAndView viewDatamodel(ModelAndView model) {
		List<DataModel> datamodelList = datamodelService.getAllDatamodel();
		model.addObject("datamodelList", datamodelList);
		model.setViewName("datamodelList");
		return model;
	}
	
	
	@RequestMapping(value = "/viewTable", method = RequestMethod.GET)
	public ModelAndView viewTable(ModelAndView model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		List<DataModel> datamodelList = datamodelService.getAllDatamodel();
		model.addObject("datamodelList", datamodelList);
		Integer id_datamodel = Integer.parseInt(request.getParameter("id_datamodel"));
		session.setAttribute("id_datamodel",id_datamodel);
		List<String> datamodelDecriptList = datamodelService.getdmdByIdDatamodel(id_datamodel);
		model.addObject("datamodelDecriptList", datamodelDecriptList);
		model.setViewName("datamodelList");
		return model;
	}
	
	@RequestMapping(value = "/viewAttribute", method = RequestMethod.GET)
	public ModelAndView viewAttribute(ModelAndView model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		List<DataModel> datamodelList = datamodelService.getAllDatamodel();
		model.addObject("datamodelList", datamodelList);
		
		
		Integer id_datamodel = (Integer) session.getAttribute("id_datamodel");
		List<String> datamodelDecriptList = datamodelService.getdmdByIdDatamodel(id_datamodel);
		model.addObject("datamodelDecriptList", datamodelDecriptList);
		
		String table_name = request.getParameter("table_name");
		List<String> attributes = datamodelService.getAttributesByTable(table_name);
		model.addObject("attributes", attributes);
		model.setViewName("datamodelList");
		return model;
	}
	
	@RequestMapping(value = "main/deleteDataModel", method = RequestMethod.GET)
	public ModelAndView deleteDataModel(ModelAndView model,HttpServletRequest request) {
		List<DataModel> listDMDelete = datamodelService.getAllDatamodel();
		model.addObject("listDMDelete", listDMDelete);
		model.setViewName("datamodelDelete");
		return model;
	}
	@RequestMapping(value = "/actionDelete", method = RequestMethod.GET)
	public ModelAndView actionDelete(HttpServletRequest request) {
		String database_name = request.getParameter("database_name");
		String version = request.getParameter("version");
		datamodelService.deleteDataModel(database_name,version);	
		return new ModelAndView("redirect:/main");
	}
}
