package com.mkyong.users.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RULE_TBL")
public class Rule implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_rule;
	
	@Column
	private String operator;

	@Column
	private String property;

	@Column
	private String state;

	@Column
	private String criticity;

	@Column
	private String priority;
	
	@Column
	private String version;

	public Rule(int id_rule, String operator, String property, String state, String criticity, String priority,
			String version) {
		super();
		this.id_rule = id_rule;
		this.operator = operator;
		this.property = property;
		this.state = state;
		this.criticity = criticity;
		this.priority = priority;
		this.version = version;
	}

	public Rule() {
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
	
	public String toString() {
		return this.id_rule +" "+this.operator +" "+ this.state + this.property + this.criticity + this.priority 
		+ this.version;
		
	}
	

}
