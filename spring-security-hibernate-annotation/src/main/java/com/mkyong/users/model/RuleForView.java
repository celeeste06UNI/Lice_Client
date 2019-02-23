package com.mkyong.users.model;

import java.util.List;

import javax.persistence.Column;

public class RuleForView {
	

	private int id_rule;
	private int id_project;
	private String operator;
	private String property;
	private String state;
	private String criticity;
	private String priority;
	private String version;
	private String description;
	private List<Catalogue> catalogueL;
	
	public RuleForView(int id_rule, int id_project, String operator, String property, String state, String criticity, String priority,
			String version, String description) {
		super();
		this.id_rule = id_rule;
		this.id_project = id_project;
		this.operator = operator;
		this.property = property;
		this.state = state;
		this.criticity = criticity;
		this.priority = priority;
		this.version = version;
		this.description = description;
	}
	
	
	public List<Catalogue> getCatalogueL() {
		return catalogueL;
	}

	public void setCatalogueL(List<Catalogue> catalogueL) {
		this.catalogueL = catalogueL;
	}

	public RuleForView(int id_rule, String operator, String property, String state, String criticity, String priority,
			String version, String description) {
		super();
		this.id_rule = id_rule;
		this.operator = operator;
		this.property = property;
		this.state = state;
		this.criticity = criticity;
		this.priority = priority;
		this.version = version;
		this.description = description;
	}
	
	
	public RuleForView() {
	}

	public RuleForView(int id_rule2, String operator2, String property2, String state2, String criticity2,
			String priority2, String version2, String cadenaFinal, List<Catalogue> catalogueL) {
		super();
		this.id_rule = id_rule2;
		this.operator = operator2;
		this.property = property2;
		this.state = state2;
		this.criticity = criticity2;
		this.priority = priority2;
		this.version = version2;
		this.description = cadenaFinal;
		this.catalogueL = catalogueL;
	}
	
	public RuleForView(int id_rule, int id_project, String operator, String property, String state, String criticity, String priority,
			String version, String description,  List<Catalogue> catalogueL) {
		super();
		this.id_rule = id_rule;
		this.id_project = id_project;
		this.operator = operator;
		this.property = property;
		this.state = state;
		this.criticity = criticity;
		this.priority = priority;
		this.version = version;
		this.description = description;
		this.catalogueL = catalogueL;
	}

	public int getId_project() {
		return id_project;
	}
	
	public int getId_rule() {
		return id_rule;
	}

	public void setId_rule(int id_rule) {
		this.id_rule = id_rule;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCriticity() {
		return criticity;
	}

	public void setCriticity(String criticity) {
		this.criticity = criticity;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return this.id_rule +" "+this.operator +" "+ this.state + this.property + this.criticity + this.priority 
		+ this.version +  this.description;
		
	}

}
