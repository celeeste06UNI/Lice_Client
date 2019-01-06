package com.mkyong.users.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RULE_PROJ_TBL")
public class RuleProj implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private int id_rule;
	
	@Id
	@Column
	private int id_project;


	public RuleProj(int id_rule, int id_project) {
		super();
		this.id_rule = id_rule;
		this.id_project = id_project;
	}

	public RuleProj() {
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

	
	public String toString() {
		return this.id_rule +" "+ this.id_project;
		
	}
}
