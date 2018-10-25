package com.mkyong.web.controller;

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
/*	@RequestMapping(value = "/saveOrganization", method = RequestMethod.POST)
	public String saveOrganization(@RequestParam(value = "id") int id, @RequestParam(value = " cif") int cif,@RequestParam(value = "name_org") String name_org,
			@RequestParam(value = "name_trade") String name_trade, @RequestParam(value = "name_contact") String name_contact,
			@RequestParam(value = "role_contact") String role_contact, @RequestParam(value = "telephone_contact") String telephone_contact) {
		Organization organization = new Organization(id, cif,name_org, name_trade, name_contact, role_contact,telephone_contact);
		organizationService.addOrganization(organization);
		return "main";
	}*/

}
