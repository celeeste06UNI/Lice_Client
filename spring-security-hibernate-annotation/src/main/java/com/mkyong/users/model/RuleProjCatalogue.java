package com.mkyong.users.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RULE_PROJ_CATALOGUE_TBL")
public class RuleProjCatalogue implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private int id_rule;
	
	@Id
	@Column
	private int id_project;
	
	@Id
	@Column
	private int id_catalogue;

	public RuleProjCatalogue(int id_rule, int id_project, int id_catalogue) {
		super();
		this.id_rule = id_rule;
		this.id_project = id_project;
		this.id_catalogue = id_catalogue;
	}

	public RuleProjCatalogue() {

	}
	
	
	
	public int getId_rule() {
		return id_rule;
	}

	public void setId_rule(int id_rule) {
		this.id_rule = id_rule;
	}

	public int getId_project() {
		return id_project;
	}

	public void setId_project(int id_project) {
		this.id_project = id_project;
	}

	public int getId_catalogue() {
		return id_catalogue;
	}

	public void setId_catalogue(int id_catalogue) {
		this.id_catalogue = id_catalogue;
	}

	public String toString() {
		return this.id_rule + " " + this.id_project+ " " + this.id_catalogue;
		
	}

}
