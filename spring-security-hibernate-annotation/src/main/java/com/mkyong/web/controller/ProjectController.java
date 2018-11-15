package com.mkyong.web.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.users.model.DataModel;
import com.mkyong.users.model.Organization;
import com.mkyong.users.model.Personal;
import com.mkyong.users.model.Project;
import com.mkyong.users.service.DatamodelService;
import com.mkyong.users.service.OrganizationService;
import com.mkyong.users.service.PersonalService;
import com.mkyong.users.service.ProjectService;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


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
			@ModelAttribute("finish_date") String finalizar) throws ParseException {
	
		int id = 0;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(inicio);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
		java.util.Date date1 = sdf1.parse(finalizar);
		java.sql.Date sqlStartDate1 = new java.sql.Date(date.getTime()); 
		projectService.addProject(id,id_personal, id_organization, id_datamodel, sqlStartDate,sqlStartDate1);
		return new ModelAndView("redirect:/main");
	}
	
	@RequestMapping(value = "main/viewOpenProject", method = RequestMethod.GET)
	public ModelAndView viewOpenProject(ModelAndView model) {
		List<Project> listOpenProject = null; //= organizationService.getAllOrganization();
		model.addObject("listOpenProject", listOpenProject);
		model.setViewName("openProjectList");
		return model;
	}
	
	@RequestMapping(value = "main/viewCloseProject", method = RequestMethod.GET)
	public ModelAndView viewCloseProject(ModelAndView model) {
		List<Project> listCloseProject = null; //= organizationService.getAllOrganization();
		model.addObject("listCloseProject", listCloseProject);
		model.setViewName("closeProjectList");
		return model;
	}

}
