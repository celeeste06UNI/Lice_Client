package com.mkyong.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.users.model.Catalogue;
import com.mkyong.users.model.Organization;
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
	public ModelAndView newCatalogue(ModelAndView model) {
		model.setViewName("catalogueForm");
		return model;
	}
	
	@RequestMapping(value = "main/viewCatalogue", method = RequestMethod.GET)
	public ModelAndView viewCatalogue(ModelAndView model) {
		List<Catalogue> listCatalogue = catalogueService.getAllCatalogue();
		model.addObject("listCatalogue", listCatalogue);
		model.setViewName("catalogueList");
		return model;
	}

	@RequestMapping(value = "/saveCatalogue", method = RequestMethod.POST)
	public ModelAndView saveCatalogue(ModelAndView model, HttpServletRequest request) {
		int id_catalogue = 0;
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		catalogueService.addCatalogue(id_catalogue, name, description);
		model.setViewName("catalogueForm");
		return model;
	}
}