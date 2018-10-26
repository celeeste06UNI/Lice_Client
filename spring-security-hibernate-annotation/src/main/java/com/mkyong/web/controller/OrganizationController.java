package com.mkyong.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.users.model.Organization;
import com.mkyong.users.model.Personal;
import com.mkyong.users.model.User;
import com.mkyong.users.service.OrganizationService;

@Controller
public class OrganizationController {
	//private static final Logger logger = Logger.getLogger(OrganizationController.class);
	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping(value = "main/newOrganization", method = RequestMethod.GET)
	public ModelAndView newOrganization(ModelAndView model) {
		Organization organization = new Organization();
		model.addObject("organization", organization);
		model.setViewName("organizationForm");
		return model;
	}

	@RequestMapping(value = "/saveOrganization", method = RequestMethod.POST)
	public ModelAndView saveOrganization(@ModelAttribute("organization") Organization organization) {

		organizationService.addOrganization(organization);

		return new ModelAndView("redirect:/main");
	}

	@RequestMapping(value = "main/viewOrganization", method = RequestMethod.GET)
	public ModelAndView viewOrganization(ModelAndView model) {
		List<Organization> listOrganization = organizationService.getAllOrganization();
		model.addObject("listOrganization", listOrganization);
		model.setViewName("organizationList");
		return model;
	}
	@RequestMapping(value = "/deleteOrganization", method = RequestMethod.GET)
	public ModelAndView deleteOrganization(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		organizationService.deleteOrganization(id);		
		return new ModelAndView("redirect:/main");
	}
	
	@RequestMapping(value = "/editOrganization", method = RequestMethod.GET)
	public ModelAndView editOrganization(ModelAndView model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Organization organization = organizationService.getOrganization(id);
		model.addObject("organization", organization);
		model.setViewName("organizationUpdate");
		return model;
	}
	
	@RequestMapping(value = "/updateOrganization", method = RequestMethod.POST)
	public ModelAndView updateOrganization(@ModelAttribute("organization") Organization organization) {
		organizationService.updateOrganization(organization);
		return new ModelAndView("redirect:/main");
	}

}
