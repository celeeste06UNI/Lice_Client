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

import com.mkyong.users.model.Attribute;
import com.mkyong.users.model.Catalogue;
import com.mkyong.users.model.DataModel;
import com.mkyong.users.model.Organization;
import com.mkyong.users.model.Personal;
import com.mkyong.users.model.Project;
import com.mkyong.users.model.Rule;
import com.mkyong.users.model.RuleProj;
import com.mkyong.users.model.RuleProjCatalogue;
import com.mkyong.users.service.CatalogueService;
import com.mkyong.users.service.ProjectService;
import com.mkyong.users.service.RuleService;


@Controller
public class RuleController {

	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private ProjectService projectService;
	@Autowired
	private RuleService ruleService;
	

	public RuleController() {
		System.out.println("RuleController()");
	}
	
	@RequestMapping(value = "main/viewRule", method = RequestMethod.GET)
	public ModelAndView viewRule(ModelAndView model) {
		List<Rule> listRule = null;
		model.addObject("listRule", listRule);
		model.setViewName("ruleList");
		return model;
	}

	@RequestMapping(value = "main/newRule", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model,  HttpServletRequest request) {
		Integer numeroAtributos = (Integer) model.getModel().get("numberAt");
		List<Project> projectList = projectService.getOpenProject();
		
		model.addObject("numberContr", numeroAtributos);
		model.addObject("projectList", projectList);
		
		model.setViewName("ruleForm");
		return model;
	}
	
	@RequestMapping(value = "/saveRule", method = RequestMethod.GET)
	public ModelAndView saveRule(ModelAndView model, HttpServletRequest request) {
		int id_project = Integer.parseInt(request.getParameter("id_project"));
		int numeroAtributos = Integer.parseInt(request.getParameter("bucle"));
		String operador = request.getParameter("operador");
		int id_rule = 0;
		int id_attribute = 0;
		
		String property = request.getParameter("propiedad");
		String state = request.getParameter("estado");
		String criticity = request.getParameter("criticidad");
		String priority = request.getParameter("prioridad");
		String version = request.getParameter("version");
		int id_catalogue = Integer.parseInt(request.getParameter("catalogo"));
		Rule rule = new Rule(id_rule,property,state,criticity,priority,version);
		//Insertar la regla
		ruleService.addRule(rule);
		//Recoger el id de la ultima regla insertada id_rule = getLastRule().getId_rule;
		id_rule = ruleService.getLastRule().getId_rule();
		//System.out.println("<<<<<"+id_rule);
		RuleProj ruleProj = new RuleProj(id_rule, id_project);
		//Insertar en la tabla para relacionar el proyecto con la regla
		ruleService.addRuleProj(ruleProj);
		
		
		for(int i = 1; i<numeroAtributos + 1; i++) {
			String modal_operator = request.getParameter("cuantificador" + i);
			String term = request.getParameter("termino" + i);
			String verb = request.getParameter("verbo" + i);
			String logical_operator = request.getParameter("operadorLogi" + i);
			String term_value = request.getParameter("valorAt" + i);
			Attribute attribute = new Attribute(id_attribute,id_rule,modal_operator,term,verb,logical_operator,term_value);
			//Insertar los atributos
			ruleService.addAttribute(attribute);
		}
		
		
		if(id_catalogue!=0) {
			RuleProjCatalogue ruleProjectCatalogue = new RuleProjCatalogue(id_rule, id_project, id_catalogue);
			//Insertar la relacion con el catalogo
			ruleService.addRuleProjCatalogue(ruleProjectCatalogue);
		}
		
		model.setViewName("ruleForm");
		return model;
	}

	


}
