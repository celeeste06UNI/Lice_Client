package com.mkyong.users.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DATAMODEL_TBL", catalog = "test_apps")
public class DataModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private String database_name;

	@Id
	@Column
	private String table_name;

	@Column
	private String table_type;
	
	@Id
	@Column
	private String column_name;

	@Column
	private String column_type;
	
	@Column
	private String column_key;
	
	@Column
	private String isnullable;
	
	public DataModel(String database_name, String table_name, String table_type, String column_name, String column_type,
			String column_key, String isnullable) {
		super();
		this.database_name = database_name;
		this.table_name = table_name;
		this.table_type = table_type;
		this.column_name = column_name;
		this.column_type = column_type;
		this.column_key = column_key;
		this.isnullable = isnullable;
	}

	public DataModel() {

	}

	public String getDatabase_name() {
		return database_name;
	}

	public void setDatabase_name(String database_name) {
		this.database_name = database_name;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getTable_type() {
		return table_type;
	}

	public void setTable_type(String table_type) {
		this.table_type = table_type;
	}

	public String getColumn_name() {
		return column_name;
	}

	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}

	public String getColumn_type() {
		return column_type;
	}

	public void setColumn_type(String column_type) {
		this.column_type = column_type;
	}

	public String getColumn_key() {
		return column_key;
	}

	public void setColumn_key(String column_key) {
		this.column_key = column_key;
	}

	public String isIsnullable() {
		return isnullable;
	}

	public void setIsnullable(String isnullable) {
		this.isnullable = isnullable;
	}
	
	public String toString() {
		
		return this.database_name + this.table_name + this.table_type+this.column_name+this.column_type
				+this.column_key + this.isnullable;
		
	}
	
	

}
