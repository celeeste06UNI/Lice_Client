package com.mkyong.users.model;

public class ProjectForView {
	
	private String name_emp;
	private String name_org;
	private String name_datamodel;
	private String start_date;
	private String finish_date;
	private int rules;
	
	public ProjectForView(String name_emp, String name_org, String name_datamodel, String start_date,
			String finish_date, int rules) {
		super();
		this.name_emp = name_emp;
		this.name_org = name_org;
		this.name_datamodel = name_datamodel;
		this.start_date = start_date;
		this.finish_date = finish_date;
		this.rules = rules;
	}

	public ProjectForView() {

	}
	
	public String getName_emp() {
		return name_emp;
	}

	public void setName_emp(String name_emp) {
		this.name_emp = name_emp;
	}

	public String getName_org() {
		return name_org;
	}

	public void setName_org(String name_org) {
		this.name_org = name_org;
	}

	public String getName_datamodel() {
		return name_datamodel;
	}

	public void setName_datamodel(String name_datamodel) {
		this.name_datamodel = name_datamodel;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(String finish_date) {
		this.finish_date = finish_date;
	}

	public int getRules() {
		return rules;
	}

	public void setRules(int rules) {
		this.rules = rules;
	}
	
	

}
