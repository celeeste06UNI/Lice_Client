package com.mkyong.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.users.model.Attribute;
import com.mkyong.users.model.Catalogue;
import com.mkyong.users.model.Project;
import com.mkyong.users.model.Rule;
import com.mkyong.users.model.RuleForView;
import com.mkyong.users.model.RuleProj;
import com.mkyong.users.service.CatalogueService;
import com.mkyong.users.service.ProjectService;
import com.mkyong.users.service.RuleService;

@Controller
public class CodeController {

	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private ProjectService projectService;
	@Autowired
	private RuleService ruleService;
	@Autowired
	private CatalogueService catalogueService;

	public CodeController() {
		System.out.println("CodeController()");
	}
	
	@RequestMapping(value = "main/newCode", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, HttpServletRequest request) {
		List<Project> projectList = projectService.getOpenProject();
		model.addObject("projectList", projectList);
		model.setViewName("createCodeList");
		return model;
	}

	@RequestMapping(value = "/viewRuleCode", method = RequestMethod.GET)
	public ModelAndView viewRule(ModelAndView model, HttpServletRequest request) {
		List<Project> projectList = projectService.getOpenProject();
		int id_project = Integer.parseInt(request.getParameter("project"));
		List<Rule> listRule = new ArrayList<Rule>();
		List<RuleForView> listRuleView = new ArrayList<RuleForView>();
		List<RuleProj> listRuleProj = ruleService.getRulesByProject(id_project);
		
		for(int z = 0; z<listRuleProj.size(); z++) {
			
			int id_r = listRuleProj.get(z).getId_rule();
			Rule rule = ruleService.getRule(id_r);
			System.out.println("HOLA"+rule);
			listRule.add(rule);
		}

		for (int i = 0; i < listRule.size(); i++) {
			String cadenaFinal = "";
			String operator = listRule.get(i).getOperator();
			String property = listRule.get(i).getProperty();
			String state = listRule.get(i).getState();
			String criticity = listRule.get(i).getCriticity();
			String priority = listRule.get(i).getPriority();
			String version = listRule.get(i).getVersion();
			int id_rule = listRule.get(i).getId_rule();
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
			System.out.println(cadenaFinal);
			RuleForView ruleView = new RuleForView(id_rule, operator, property, state, criticity, priority, version,
					cadenaFinal);

			listRuleView.add(ruleView);
		}
		model.addObject("projectList", projectList);
		model.addObject("listRuleView", listRuleView);
		model.setViewName("createCodeList");
		return model;
	}
}
