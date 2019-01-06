package com.mkyong.users.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ATTRIBUTE_TBL")
public class Attribute implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_attribute;
	
	@Column
	private int id_rule;
	
	@Column
	private String modal_operator;

	@Column
	private String term;

	@Column
	private String verb;

	@Column
	private String logical_operator;

	@Column
	private String term_value;

	public Attribute(int id_attribute, int id_rule, String modal_operator, String term, String verb,
			String logical_operator, String term_value) {
		super();
		this.id_attribute = id_attribute;
		this.id_rule = id_rule;
		this.modal_operator = modal_operator;
		this.term = term;
		this.verb = verb;
		this.logical_operator = logical_operator;
		this.term_value = term_value;
	}

	public Attribute() {
		
	}

	public int getId_attribute() {
		return id_attribute;
	}

	public void setId_attribute(int id_attribute) {
		this.id_attribute = id_attribute;
	}

	public int getId_rule() {
		return id_rule;
	}

	public void setId_rule(int id_rule) {
		this.id_rule = id_rule;
	}

	public String getModal_operator() {
		return modal_operator;
	}

	public void setModal_operator(String modal_operator) {
		this.modal_operator = modal_operator;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public String getLogical_operator() {
		return logical_operator;
	}

	public void setLogical_operator(String logical_operator) {
		this.logical_operator = logical_operator;
	}

	public String getTerm_value() {
		return term_value;
	}

	public void setTerm_value(String term_value) {
		this.term_value = term_value;
	}
	
	public String toString() {
		return this.id_attribute + this.id_rule + this.modal_operator + this.term + this.verb + this.logical_operator 
		+ this.term_value;
		
	}
	
}
