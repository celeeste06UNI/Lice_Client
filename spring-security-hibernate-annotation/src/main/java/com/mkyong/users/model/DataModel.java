package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DATAMODEL_TBL")
public class DataModel {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_datamodel;

	@Column
	private String database_name;

	@Column
	private String version;

	public DataModel(int id_datamodel, String database_name, String version) {
		super();
		this.id_datamodel = id_datamodel;
		this.database_name = database_name;
		this.version = version;
	}

	public DataModel() {
	}

	public int getId_datamodel() {
		return id_datamodel;
	}

	public void setId_datamodel(int id_datamodel) {
		this.id_datamodel = id_datamodel;
	}

	public String getDatabase_name() {
		return database_name;
	}

	public void setDatabase_name(String database_name) {
		this.database_name = database_name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public String toString() {
		
		return this.database_name + this.id_datamodel + this.version;
		
	}
}
