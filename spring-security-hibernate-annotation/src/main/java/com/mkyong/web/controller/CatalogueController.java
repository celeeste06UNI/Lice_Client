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
import com.mkyong.users.model.CatalogueForView;
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
		int num_rules = 0;
		List<Catalogue> listCatalogue = catalogueService.getAllCatalogue();
		List<CatalogueForView> listCatalogueForView = new ArrayList<CatalogueForView>();
		for(int i = 0; i< listCatalogue.size(); i++) {
			num_rules = catalogueService.getRuleProjCatalogue(listCatalogue.get(i).getId_catalogue());
			CatalogueForView catalogueForView = new CatalogueForView(listCatalogue.get(i).getId_catalogue(), listCatalogue.get(i).getName(),
					listCatalogue.get(i).getDescription(), num_rules);
			listCatalogueForView.add(catalogueForView);
		}
		model.addObject("listCatalogue", listCatalogueForView);
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
	
	@RequestMapping(value = "/deleteCatalogue", method = RequestMethod.GET)
	public ModelAndView deleteOrganization(HttpServletRequest request) {
		Integer id_catalogue = Integer.parseInt(request.getParameter("id_catalogue"));
		catalogueService.deleteCatalogue(id_catalogue);		
		return new ModelAndView("redirect:/main");
	}
	
	@RequestMapping(value = "/editCatalogue", method = RequestMethod.GET)
	public ModelAndView editCatalogue(ModelAndView model, HttpServletRequest request) {
		Integer id_catalogue = Integer.parseInt(request.getParameter("id_catalogue"));
		Catalogue catalogue = catalogueService.getCatalogue(id_catalogue);
		model.addObject("catalogue", catalogue);
		model.setViewName("catalogueUpdate");
		return model;
	}
	
	@RequestMapping(value = "/updateCatalogue", method = RequestMethod.POST)
	public ModelAndView updateCatalogue(@ModelAttribute("catalogue") Catalogue catalogue) {
		catalogueService.updateCatalogue(catalogue);
		return new ModelAndView("redirect:/main");
	}
	@RequestMapping(value = "/deleteToCatalogue", method = RequestMethod.GET)
	public ModelAndView deleteToCatalogue(ModelAndView model, HttpServletRequest request) {
		Integer id_rule = Integer.parseInt(request.getParameter("id_r"));
		Integer id_project = Integer.parseInt(request.getParameter("id_p"));
		List <Catalogue> listaCatalogos = catalogueService.getCatalogues(id_rule, id_project);
		model.addObject("listaCatalogos", listaCatalogos);
		model.addObject("id_proj",id_project);
		model.addObject("id_rule",id_rule);
		model.setViewName("selectCatalogue");
		return model;
	}
	@RequestMapping(value = "/addToCatalogue", method = RequestMethod.GET)
	public ModelAndView addToCatalogue(ModelAndView model, HttpServletRequest request) {
		Integer id_rule = Integer.parseInt(request.getParameter("id_r"));
		Integer id_project = Integer.parseInt(request.getParameter("id_p"));
		List <Catalogue> listaCatalogos = catalogueService.getAllCatalogue();
		model.addObject("listaCatalogos", listaCatalogos);
		model.addObject("id_proj",id_project);
		model.addObject("id_rule",id_rule);
		model.setViewName("selectCatalogueAdd");
		return model;
	}
	@RequestMapping(value = "/deleteRuleProjCatalogue", method = RequestMethod.GET)
	public ModelAndView deleteRuleProjCatalogue(@ModelAttribute("catalogue") Integer id_c,HttpServletRequest request) {
		Integer id_catalogue = id_c;
		Integer id_rule = Integer.parseInt(request.getParameter("id_rule"));
		Integer id_project = Integer.parseInt(request.getParameter("id_proj"));
		catalogueService.deleteRuleProjCatalogue(id_rule,id_project,id_catalogue);	
		return new ModelAndView("redirect:/main");
	}
	
	@RequestMapping(value = "/addRuleProjCatalogue", method = RequestMethod.GET)
	public ModelAndView addRuleProjCatalogue(@ModelAttribute("catalogue") Integer id_c,HttpServletRequest request) {
		Integer id_catalogue = id_c;
		Integer id_rule = Integer.parseInt(request.getParameter("id_rule"));
		Integer id_project = Integer.parseInt(request.getParameter("id_proj"));
		catalogueService.addRuleProjCatalogue(id_rule,id_project,id_catalogue);	
		return new ModelAndView("redirect:/main");
	}
}


