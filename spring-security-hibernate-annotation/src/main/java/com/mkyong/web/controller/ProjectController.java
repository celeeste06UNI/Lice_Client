package com.mkyong.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.users.model.DataModel;
import com.mkyong.users.model.Organization;
import com.mkyong.users.model.Personal;
import com.mkyong.users.model.User;
import com.mkyong.users.service.DatamodelService;
import com.mkyong.users.service.OrganizationService;
import com.mkyong.users.service.PersonalService;


@Controller
public class ProjectController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private PersonalService personalService;
	@Autowired
	private DatamodelService datamodelService;
	
	@RequestMapping(value = "main/newProject", method = RequestMethod.GET)
	public ModelAndView newProject(ModelAndView model) {
		List<Organization> organizationList = organizationService.getAllOrganization();
		List<String> datamodelList = datamodelService.getAllNameDatamodel();
		List<Personal> personalList = personalService.getAllPersonal();
		model.addObject("organizationList", organizationList);
		model.addObject("datamodelList", datamodelList);
		model.addObject("personalList", personalList);
		model.setViewName("projectForm");
		return model;
	}
	
/*	@RequestMapping(value = "/saveProject", method = RequestMethod.POST)
	public ModelAndView saveProject(@ModelAttribute("personal") Personal personal,
			@ModelAttribute("role") String role) {
		

		String password = role + ((int)(Math.random() * 50) + 1);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String passwordEncriptada = passwordEncoder.encode(password);
		User user = new User(personal.getUsername(), passwordEncriptada, true);
		
		personalService.addPersonal(personal, password);
		personalService.addUserRole(user, role);
		

		return new ModelAndView("redirect:/main");
	}*/

}
