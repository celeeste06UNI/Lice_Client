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
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.users.model.Catalogue;
import com.mkyong.users.model.DataModel;
import com.mkyong.users.model.Organization;
import com.mkyong.users.model.Personal;
import com.mkyong.users.model.Project;
import com.mkyong.users.service.CatalogueService;
import com.mkyong.users.service.ProjectService;


@Controller
public class RuleController {

	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private ProjectService projectService;
	@Autowired
	private CatalogueService catalogueService;

	public RuleController() {
		System.out.println("RuleController()");
	}

	@RequestMapping(value = "main/newRule", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model,  HttpServletRequest request) {
		Integer numeroAtributos = (Integer) model.getModel().get("numberAt");
		List<Project> projectList = projectService.getOpenProject();
		List<Catalogue> catalogueList = catalogueService.getAllCatalogue();
		model.addObject("numberContr", numeroAtributos);
		model.addObject("projectList", projectList);
		model.addObject("catalogueList", catalogueList);
		model.setViewName("ruleForm");
		return model;
	}
	
	@RequestMapping(value = "/saveRule", method = RequestMethod.GET)
	public ModelAndView saveRule(ModelAndView model, HttpServletRequest request) {
		Integer numeroAtributos = Integer.parseInt(request.getParameter("bucle"));
		String operador = request.getParameter("operador");
		for(int i = 1; i<numeroAtributos + 1; i++) {
			String cuantificador = request.getParameter("cuantificador" + i);
			String termino = request.getParameter("termino" + i);
			String verbo = request.getParameter("verbo" + i);
			String operadorLogi = request.getParameter("operadorLogi" + i);
			String valorAt = request.getParameter("valorAt" + i);
			System.out.println(operador + " " + cuantificador + " " + termino + " "+ verbo + " " + operadorLogi 
					+ " " + valorAt);
			//Crear un objeto atributoRegla con todos estos datos 
		}
		String propiedad = request.getParameter("propiedad");
		String estado = request.getParameter("estado");
		String criticidad = request.getParameter("criticidad");
		String prioridad = request.getParameter("prioridad");
		String version = request.getParameter("version");
		String catalogo = request.getParameter("catalogo");
		
		model.setViewName("ruleForm");
		return model;
	}
}
