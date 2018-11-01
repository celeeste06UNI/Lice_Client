package com.mkyong.users.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORG_TBL")
public class Organization implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private int cif;

	@Column
	private String name_org;

	@Column
	private String name_trade;

	@Column
	private String name_contact;

	@Column
	private String role_contact;
	
	@Column
	private String telephone_contact;
	
	public Organization(int id, int cif, String name_org, String name_trade, String name_contact,
			String role_contact, String telephone_contact) {
		this.id = id;
		this.cif = cif;
		this.name_org = name_org;
		this.name_trade = name_trade;
		this.name_contact = name_contact;
		this.role_contact = role_contact;
		this.telephone_contact = telephone_contact;
	}

	public Organization() {

	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCif() {
		return cif;
	}

	public void setCif(int cif) {
		this.cif = cif;
	}

	public String getName_org() {
		return name_org;
	}

	public void setName_org(String name_org) {
		this.name_org = name_org;
	}

	public String getName_trade() {
		return name_trade;
	}

	public void setName_trade(String name_trade) {
		this.name_trade = name_trade;
	}

	public String getName_contact() {
		return name_contact;
	}

	public void setName_contact(String name_contact) {
		this.name_contact = name_contact;
	}

	public String getRole_contact() {
		return role_contact;
	}

	public void setRole_contact(String role_contact) {
		this.role_contact = role_contact;
	}

	public String getTelephone_contact() {
		return telephone_contact;
	}

	public void setTelephone_contact(String telephone_contact) {
		this.telephone_contact = telephone_contact;
	}
}