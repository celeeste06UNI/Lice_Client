package com.mkyong.web.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
import com.mkyong.users.model.Project;
import com.mkyong.users.model.User;
import com.mkyong.users.service.DatamodelService;
import com.mkyong.users.service.OrganizationService;
import com.mkyong.users.service.PersonalService;
import com.mkyong.users.service.ProjectService;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Locale;

@Controller
public class ProjectController {

	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private PersonalService personalService;
	@Autowired
	private DatamodelService datamodelService;
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "main/newProject", method = RequestMethod.GET)
	public ModelAndView newProject(ModelAndView model) {
		List<Organization> organizationList = organizationService.getAllOrganization();
		List<DataModel> datamodelList = datamodelService.getAllDatamodel();
		List<Personal> personalList = personalService.getAllPersonal();
		model.addObject("organizationList", organizationList);
		model.addObject("datamodelList", datamodelList);
		model.addObject("personalList", personalList);
		model.setViewName("projectForm");
		return model;
	}

	@RequestMapping(value = "/saveProject", method = RequestMethod.POST)
	public ModelAndView saveProject(@ModelAttribute("organization") int id_organization,
			@ModelAttribute("datamodel") int id_datamodel,
			@ModelAttribute("personal") int id_personal,
			@ModelAttribute("start_date") String inicio, 
			@ModelAttribute("finish_date") String finalizar) {
	
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		
		Date start_date = null;
		Date finish_date = null;
		
		try {

			start_date = formatoDelTexto.parse(inicio);
			finish_date = formatoDelTexto.parse(finalizar);
			if(start_date != null && finish_date!=null) {
				int id = 0;
				projectService.addProject(id,id_personal, id_organization, id_datamodel, start_date,finish_date);
			}

		} catch (ParseException ex) {

		ex.printStackTrace();

		}



		return new ModelAndView("redirect:/main");
	}

}
