package com.mkyong.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.users.model.Personal;
import com.mkyong.users.service.CatalogueService;



@Controller
public class CatalogueController {

	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private CatalogueService catalogueService;

	public CatalogueController() {
		System.out.println("CatalogueController()");
	}
	@RequestMapping(value = "main/newCatalogue", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		model.setViewName("catalogueForm");
		return model;
	}

	@RequestMapping(value = "main/saveCatalogue", method = RequestMethod.POST)
	public ModelAndView newCatalogue(ModelAndView model,  HttpServletRequest request) {
		int id_catalogue = 0;
		String name_catalogue = request.getParameter("name_catalogue");
		String description = request.getParameter("description");
		catalogueService.addCatalogue(id_catalogue, name_catalogue, description);
		return model;
	}
}