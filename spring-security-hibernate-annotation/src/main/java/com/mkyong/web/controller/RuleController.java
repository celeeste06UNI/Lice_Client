package com.mkyong.web.controller;

import java.util.ArrayList;
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
import com.mkyong.users.model.RuleForView;
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
	@Autowired
	private CatalogueService catalogueService;

	public RuleController() {
	}

	@RequestMapping(value = "main/viewRule", method = RequestMethod.GET)
	public ModelAndView viewRule(ModelAndView model) {
		List<RuleForView> listRuleView = new ArrayList<RuleForView>();
		List<Rule> listRule = ruleService.getAllRule();
		//List<Catalogue> catalogueList = new ArrayList<Catalogue>();
		
		for (int i = 0; i < listRule.size(); i++) {
			String cadenaFinal = "";
			String operator = listRule.get(i).getOperator();
			String property = listRule.get(i).getProperty();
			String state = listRule.get(i).getState();
			String criticity = listRule.get(i).getCriticity();
			String priority = listRule.get(i).getPriority();
			String version = listRule.get(i).getVersion();
			int id_rule = listRule.get(i).getId_rule();
			int id_project = projectService.getProjectByRule(id_rule);
			List<Catalogue> catalogueList = catalogueService.getCatalogues(id_rule, id_project);
			List<Attribute> listAttribute = ruleService.getAttributesByRule(id_rule);
			cadenaFinal = operator;
			for (int j = 0; j < listAttribute.size(); j++) {
				String modal_operator = listAttribute.get(j).getModal_operator();
				String term = listAttribute.get(j).getTerm();
				String verb = listAttribute.get(j).getVerb();
				String logical_operator = listAttribute.get(j).getLogical_operator();
				String term_value = listAttribute.get(j).getTerm_value();
				if (logical_operator.equals("-")) {
					cadenaFinal = cadenaFinal + " " + modal_operator + " " + term + " " + verb + " " + term_value;
				} else {
					cadenaFinal = cadenaFinal + " " + modal_operator + " " + term + " " + verb + " " + logical_operator
							+ " " + term_value;
				}

				cadenaFinal = cadenaFinal + " y ";
			}
			cadenaFinal = cadenaFinal.substring(0, cadenaFinal.length() - 2);
			
			RuleForView ruleView = new RuleForView(id_rule, operator, property, state, criticity, priority, version,
					cadenaFinal, catalogueList);

			listRuleView.add(ruleView);
		}

		model.addObject("listRuleView", listRuleView);
		//model.addObject("catalogueList", catalogueList);
		model.setViewName("ruleList");
		return model;
	}
	
	@RequestMapping(value = "main/viewRuleUser", method = RequestMethod.GET)
	public ModelAndView viewRuleUser(ModelAndView model, HttpServletRequest request) {
		String username = request.getParameter("username");
		List<Rule> listRule = new ArrayList<Rule>();
		List<Project> listProjectUser = projectService.getOpenProjectUser(username);
		for(int z=0; z<listProjectUser.size();z++) {
			int  id_project = listProjectUser.get(z).getId();
			List<RuleProj> listRuleProj = ruleService.getRulesByProject(id_project);
			for(int t = 0; t< listRuleProj.size(); t++) {
				Rule rule = ruleService.getRule(listRuleProj.get(t).getId_rule());
				listRule.add(rule);
			}
		}
		List<Catalogue> listaCatalogos = new ArrayList<Catalogue>();
		List<RuleForView> listRuleView = new ArrayList<RuleForView>();
		List<Catalogue> catalogueList = catalogueService.getAllCatalogue();

		for (int i = 0; i < listRule.size(); i++) {
			String cadenaFinal = "";
			String operator = listRule.get(i).getOperator();
			String property = listRule.get(i).getProperty();
			String state = listRule.get(i).getState();
			String criticity = listRule.get(i).getCriticity();
			String priority = listRule.get(i).getPriority();
			String version = listRule.get(i).getVersion();
			int id_rule = listRule.get(i).getId_rule();
			Integer id_project = projectService.getProjectByRule(id_rule);
			listaCatalogos = catalogueService.getCatalogues(id_rule,id_project);
			List<Attribute> listAttribute = ruleService.getAttributesByRule(id_rule);
			cadenaFinal = operator;
			for (int j = 0; j < listAttribute.size(); j++) {
				String modal_operator = listAttribute.get(j).getModal_operator();
				String term = listAttribute.get(j).getTerm();
				String verb = listAttribute.get(j).getVerb();
				String logical_operator = listAttribute.get(j).getLogical_operator();
				String term_value = listAttribute.get(j).getTerm_value();
				if (logical_operator.equals("-")) {
					cadenaFinal = cadenaFinal + " " + modal_operator + " " + term + " " + verb + " " + term_value;
				} else {
					cadenaFinal = cadenaFinal + " " + modal_operator + " " + term + " " + verb + " " + logical_operator
							+ " " + term_value;
				}

				cadenaFinal = cadenaFinal + " y ";
			}
			cadenaFinal = cadenaFinal.substring(0, cadenaFinal.length() - 2);
			RuleForView ruleView = new RuleForView(id_rule, id_project, operator, property, state, criticity, priority, version,
					cadenaFinal, listaCatalogos);

			listRuleView.add(ruleView);
		}
		
		model.addObject("listRuleView", listRuleView);
		model.addObject("catalogueList", catalogueList);
		model.setViewName("ruleList");
		return model;
	}

	@RequestMapping(value = "main/newRule", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, HttpServletRequest request) {
		Integer numeroAtributos = (Integer) model.getModel().get("numberAt");
		List<Project> projectList = projectService.getOpenProject();
		model.addObject("numberContr", numeroAtributos);
		model.addObject("projectList", projectList);
		model.setViewName("ruleForm");
		return model;
	}
	
	@RequestMapping(value = "main/newRuleUser", method = RequestMethod.GET)
	public ModelAndView newContactUser(ModelAndView model, HttpServletRequest request) {
		String username = request.getParameter("username");
		Integer numeroAtributos = (Integer) model.getModel().get("numberAt");
		List<Project> projectList = projectService.getOpenProjectUser(username);
		model.addObject("numberContr", numeroAtributos);
		model.addObject("projectList", projectList);
		model.setViewName("ruleForm");
		return model;
	}

	@RequestMapping(value = "/saveRule", method = RequestMethod.GET)
	public ModelAndView saveRule(ModelAndView model, HttpServletRequest request) {
		int id_project = Integer.parseInt(request.getParameter("id_project"));
		int numeroAtributos = Integer.parseInt(request.getParameter("bucle"));
		int id_rule = 0;
		int id_attribute = 0;

		String operator = request.getParameter("operador");

		String property = request.getParameter("propiedad");
		String state = request.getParameter("estado");
		String criticity = request.getParameter("criticidad");
		String priority = request.getParameter("prioridad");
		String version = request.getParameter("version");
		int id_catalogue = Integer.parseInt(request.getParameter("catalogo"));

		Rule rule = new Rule(id_rule, operator, property, state, criticity, priority, version);
		ruleService.addRule(rule);
		id_rule = ruleService.getLastRule().getId_rule();
		RuleProj ruleProj = new RuleProj(id_rule, id_project);
		ruleService.addRuleProj(ruleProj);

		for (int i = 1; i < numeroAtributos + 1; i++) {
			String modal_operator = request.getParameter("cuantificador" + i);
			
			String term = request.getParameter("termino" + i);
			String verb = request.getParameter("verbo" + i);
			String logical_operator = request.getParameter("operadorLogi" + i);
			String term_value = request.getParameter("valorAt" + i);
			Attribute attribute = new Attribute(id_attribute, id_rule, modal_operator, term, verb, logical_operator,
					term_value);
			ruleService.addAttribute(attribute);
		}

		if (id_catalogue != 0) {
			RuleProjCatalogue ruleProjectCatalogue = new RuleProjCatalogue(id_rule, id_project, id_catalogue);
			ruleService.addRuleProjCatalogue(ruleProjectCatalogue);
		}

		model.setViewName("ruleForm");
		return model;
	}

	@RequestMapping(value = "/deleteRule", method = RequestMethod.GET)
	public ModelAndView deleteRule(HttpServletRequest request) {
		Integer id_rule = Integer.parseInt(request.getParameter("id_rule"));
		ruleService.deleteRule(id_rule);
		return new ModelAndView("redirect:/main");
	}

	@RequestMapping(value = "/updateRule", method = RequestMethod.POST)
	public ModelAndView updateRule(@ModelAttribute("id_rule") int id_rule, @ModelAttribute("operator") String operator,
			@ModelAttribute("propiedad") String property, @ModelAttribute("estado") String state,
			@ModelAttribute("criticidad") String criticity, @ModelAttribute("prioridad") String priority,
			@ModelAttribute("version") String version, @ModelAttribute("catalogo") int id_catalogue) {
		ruleService.updateRule(id_rule, operator, property, state, criticity, priority, version, id_catalogue);
		return new ModelAndView("redirect:/main");
	}

}
