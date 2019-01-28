package com.mkyong.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.users.model.Catalogue;
import com.mkyong.users.model.DataModel;
import com.mkyong.users.model.DataModelDecript;
import com.mkyong.users.model.Organization;
import com.mkyong.users.model.Personal;
import com.mkyong.users.model.Project;
import com.mkyong.users.model.ProjectForView;
import com.mkyong.users.service.CatalogueService;
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
	@Autowired
	private CatalogueService catalogueService;

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
		java.sql.Date sqlStartDate1 = new java.sql.Date(date1.getTime()); 
		
		Organization organization = organizationService.getOrganization(id_organization);
		String org_name = organization.getName_org();
		
		DataModel dataModel = datamodelService.getDataModel(id_datamodel);
		String dataModel_name = dataModel.getDatabase_name();
		
		String proj_name = org_name + "_" + dataModel_name + "_" + sqlStartDate;
		System.out.println(proj_name);
		
		projectService.addProject(id,proj_name,id_personal, id_organization, id_datamodel, sqlStartDate,sqlStartDate1);
		return new ModelAndView("redirect:/main");
	}
	
	@RequestMapping(value = "main/viewOpenProject", method = RequestMethod.GET)
	public ModelAndView viewOpenProject(ModelAndView model) {
		List<ProjectForView> listOpenProject = projectService.getOpenProjectForView();
		model.addObject("listOpenProject", listOpenProject);
		model.setViewName("openProjectList");
		return model;
	}
	
	@RequestMapping(value = "main/viewCloseProject", method = RequestMethod.GET)
	public ModelAndView viewCloseProject(ModelAndView model) {
		List<ProjectForView> listCloseProject = projectService.getCloseProjectForView();
		model.addObject("listCloseProject", listCloseProject);
		model.setViewName("closeProjectList");
		return model;
	}
	
	@RequestMapping(value = "main/selectProject", method = RequestMethod.GET)
	public ModelAndView selectProject(HttpServletRequest request, ModelAndView model, @ModelAttribute("numberAt") int numberAt) {
		int numerAtFor = numberAt;
		ArrayList<String> listAttributes = new ArrayList<String>();
		List<Project> projectList = projectService.getOpenProject();
		List<Catalogue> catalogueList = catalogueService.getAllCatalogue();
		model.addObject("projectList", projectList);
		model.addObject("numerAtFor", numerAtFor);
		int id_project = Integer.parseInt(request.getParameter("project"));
		Project project = projectService.getProject(id_project);
		System.out.println(project.getId_datamodel());
		List<DataModelDecript> dataModelDecript = datamodelService.getDatamodelDescript(project.getId_datamodel());
		for(int i= 0; i<dataModelDecript.size(); i++) {
			DataModelDecript dmd = dataModelDecript.get(i);
			String completo = dmd.getTable_name() + "." + dmd.getColumn_name();
			listAttributes.add(completo);	
		}
		model.addObject("listAttributes", listAttributes);
		model.addObject("catalogueList", catalogueList);
		model.addObject("id_project", id_project);
		model.setViewName("ruleForm");
		return model;
	}
	

}
