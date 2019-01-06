package com.mkyong.web.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.users.model.Attribute;
import com.mkyong.users.model.Catalogue;
import com.mkyong.users.model.DataModelDecript;
import com.mkyong.users.model.Personal;
import com.mkyong.users.model.Project;
import com.mkyong.users.model.Rule;
import com.mkyong.users.model.RuleForView;
import com.mkyong.users.model.RuleProj;
import com.mkyong.users.service.CatalogueService;
import com.mkyong.users.service.DatamodelService;
import com.mkyong.users.service.ProjectService;
import com.mkyong.users.service.RuleService;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
public class CodeController {

	public static String donwloadDirectory = System.getProperty("user.home") + "/download";
	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private ProjectService projectService;
	@Autowired
	private RuleService ruleService;
	@Autowired
	private CatalogueService catalogueService;
	@Autowired
	private DatamodelService datamodelService;

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

	@RequestMapping(value = "/saveSql", method = RequestMethod.POST)
	public void saveSql(ModelAndView model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("regla") String regla) throws IOException, DocumentException {
		
		String ruta = donwloadDirectory + "/archivo.pdf";
		Document documento = new Document();
		FileOutputStream ficheroPdf = new FileOutputStream(ruta);
		PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
		documento.open();
		documento.add(new Paragraph(regla));
		documento.close();

	

		FileInputStream ficheroInput = new FileInputStream(ruta);
		int tamanoInput = ficheroInput.available();
		byte[] datosPDF = new byte[tamanoInput];
		ficheroInput.read(datosPDF, 0, tamanoInput);
		response.setHeader("Content-disposition", "inline; filename=archivo.pdf");
		response.setContentType("application/pdf");
		response.setContentLength(tamanoInput);
		response.getOutputStream().write(datosPDF);
		ficheroInput.close();
	
	}
	

	@RequestMapping(value = "/viewRuleCode", method = RequestMethod.GET)
	public ModelAndView viewRule(ModelAndView model, HttpServletRequest request) {
		List<Project> projectList = projectService.getOpenProject();
		int id_project = Integer.parseInt(request.getParameter("project"));
		List<Rule> listRule = new ArrayList<Rule>();
		List<RuleForView> listRuleView = new ArrayList<RuleForView>();
		List<RuleProj> listRuleProj = ruleService.getRulesByProject(id_project);

		for (int z = 0; z < listRuleProj.size(); z++) {

			int id_r = listRuleProj.get(z).getId_rule();
			Rule rule = ruleService.getRule(id_r);
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

	@RequestMapping(value = "main/newCodeTable", method = RequestMethod.GET)
	public ModelAndView newCodeTable(ModelAndView model, HttpServletRequest request) {
		List<Project> projectList = projectService.getOpenProject();
		model.addObject("projectList", projectList);
		model.setViewName("createCodeTableList");
		return model;
	}

	@RequestMapping(value = "/viewTable", method = RequestMethod.GET)
	public ModelAndView viewTable(ModelAndView model, HttpServletRequest request) {
		int id_project = Integer.parseInt(request.getParameter("project"));
		Project project = projectService.getProject(id_project);
		int id_datamodel = project.getId_datamodel();
		//List<DataModelDecript> dmdList = datamodelService.getDatamodelDescript(id_datamodel);
		List<String> dmdList = datamodelService.getNameTableDescript(id_datamodel);

		model.addObject("proj_id", id_project);
		model.addObject("dmdList", dmdList);
		model.setViewName("createCodeTableList");
		return model;
	}

	@RequestMapping(value = "/viewRuleCodeByProperty", method = RequestMethod.GET)
	public ModelAndView viewRuleCodeByProperty(ModelAndView model, HttpServletRequest request) {
		
		List<Project> projectList = projectService.getOpenProject();
		int id_project = Integer.parseInt(request.getParameter("proj_id"));
		String propertySelect = request.getParameter("propiedad");
		String tableSelect = request.getParameter("table");
		
		List<Rule> listRule = new ArrayList<Rule>();
		List<RuleForView> listRuleView = new ArrayList<RuleForView>();
		List<RuleProj> listRuleProj = ruleService.getRulesByProject(id_project);

		for (int z = 0; z < listRuleProj.size(); z++) {
			int id_r = listRuleProj.get(z).getId_rule();
			Rule rule = ruleService.getRule(id_r);
			if(rule.getProperty().equals(propertySelect)) {
				listRule.add(rule);
			}
			
		}

		for (int i = 0; i < listRule.size(); i++) {
			int numero = 0;
			String cadenaFinal = "";
			String operator = listRule.get(i).getOperator();
			String property = listRule.get(i).getProperty();
			String state = listRule.get(i).getState();
			String criticity = listRule.get(i).getCriticity();
			String priority = listRule.get(i).getPriority();
			String version = listRule.get(i).getVersion();
			int id_rule = listRule.get(i).getId_rule();

			List<Attribute> listAttribute = ruleService.getAttributesByRule(id_rule);
			for(int h = 0; h < listAttribute.size(); h++) {
				String atributoYTabla = listAttribute.get(h).getTerm();
				String[] partes = atributoYTabla.split("\\.");
				if(partes[0].equals(tableSelect)) {
					numero += 1;
				}
			}
			
			if(numero != 0) {
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
						cadenaFinal);

				listRuleView.add(ruleView);
			}
			
			
		}
		model.addObject("projectList", projectList);
		model.addObject("listRuleView", listRuleView);
		model.setViewName("createCodeTableList");
		return model;
	}

	@RequestMapping(value = "/generateCode", method = RequestMethod.GET)
	public ModelAndView generateCode(ModelAndView model, HttpServletRequest request) {
		String sqlUnion;
		int contador = 0;
		Integer id_rule = Integer.parseInt(request.getParameter("id_rule"));
		System.out.println(id_rule);
		List<Attribute> attributeList = ruleService.getAttributesByRule(id_rule);
		String sql = "SELECT COUNT(*) FROM ";
		for (int i = 0; i < attributeList.size(); i++) {
			String tabla = "";
			String atributoYTabla = attributeList.get(i).getTerm();
			String[] partes = atributoYTabla.split("\\.");

			if (i != 0) {
				contador = 0;
				String atributoYTablaAux;
				String[] partesAux;
				String tablaAux = "";
				for (int j = 0; j < attributeList.size() - 1; j++) {
					atributoYTablaAux = attributeList.get(j).getTerm();
					partesAux = atributoYTablaAux.split("\\.");
					tablaAux = partesAux[0];
					if (!tablaAux.equals(partes[0])) {
						contador = contador + 1;
					}
				}
				if (contador != 0) {
					sql = sql + ", " + partes[0];
				}
			} else {
				sql = sql + partes[0] + " ";
			}
		}

		sqlUnion = sql;
		sql = sql + " WHERE";
		System.out.println("+++++++++++++" + sql);

		sql += " " + verbAnalysis(attributeList);
		System.out.println("+++++++++++++" + sql);

		sql += " UNION " + sqlUnion;
		sql += ";";
		System.out.println("+++++++++++++" + sql);

		model.addObject("sql", sql);
		model.setViewName("preview");
		return model;
	}

	public String verbAnalysis(List<Attribute> attributeList) {
		String sql = "";
		String sqlAux = "";
		for (int i = 0; i < attributeList.size(); i++) {
			String term = attributeList.get(i).getTerm();
			String verb = attributeList.get(i).getVerb();
			String term_value = attributeList.get(i).getTerm_value();
			String logical_operator = attributeList.get(i).getLogical_operator();
			switch (verb) {
			case "sea":
				if (term_value.equals("NULL")) {
					if (logical_operator.equals("no")) {
						sqlAux = term + " IS NOT NULL";
					} else {
						sqlAux = term + " IS NULL";
					}
				}
				break;

			default:
				System.out.println("Ningun caso");
				break;
			}

			sql += sqlAux + " AND ";
		}

		// Eliminar ultimo AND
		sql = sql.substring(0, sql.length() - 5);
		return sql;

	}
}
