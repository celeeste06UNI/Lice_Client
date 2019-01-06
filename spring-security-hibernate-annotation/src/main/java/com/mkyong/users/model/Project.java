package com.mkyong.users.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROJ_TBL")
public class Project {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String proj_name;
	
	@Column
	private int id_emp;
	
	@Column
	private int id_org;
	
	@Column
	private int id_datamodel;
	
	@Column
	private Date start_date;
	
	@Column
	private Date finish_date;

	public Project(int id, int id_emp, int id_org, int id_datamodel, Date start_date, Date finish_date) {
		this.id = id;
		this.id_emp = id_emp;
		this.id_org = id_org;
		this.id_datamodel = id_datamodel;
		this.start_date = start_date;
		this.finish_date = finish_date;
	}
	
	

	public Project(int id, String proj_name, int id_emp, int id_org, int id_datamodel, Date start_date,
			Date finish_date) {
		super();
		this.id = id;
		this.proj_name = proj_name;
		this.id_emp = id_emp;
		this.id_org = id_org;
		this.id_datamodel = id_datamodel;
		this.start_date = start_date;
		this.finish_date = finish_date;
	}



	public Project() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getProj_name() {
		return proj_name;
	}

	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}

	public int getId_emp() {
		return id_emp;
	}

	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}

	public int getId_org() {
		return id_org;
	}

	public void setId_org(int id_org) {
		this.id_org = id_org;
	}

	public int getId_datamodel() {
		return id_datamodel;
	}

	public void setId_datamodel(int id_datamodel) {
		this.id_datamodel = id_datamodel;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}
	
	public String toString() {
		
		return this.id + this.id_emp + this.id_org + this.id_datamodel + this.start_date.toString() 
		+ this.finish_date.toString();
		
	}
	

}
