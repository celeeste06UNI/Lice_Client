package com.mkyong.users.model;


public class CatalogueForView {
	


	private int id_catalogue;
	private String name;
	private String description;
	private int num_rules;
	
	public CatalogueForView(int id_catalogue, String name, String description, int num_rules) {
		super();
		this.id_catalogue = id_catalogue;
		this.name = name;
		this.description = description;
		this.num_rules = num_rules;
	}

	public int getId_catalogue() {
		return id_catalogue;
	}

	public void setId_catalogue(int id_catalogue) {
		this.id_catalogue = id_catalogue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNum_rules() {
		return num_rules;
	}

	public void setNum_rules(int num_rules) {
		this.num_rules = num_rules;
	}

	
}
