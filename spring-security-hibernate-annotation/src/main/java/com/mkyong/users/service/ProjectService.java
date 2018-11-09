package com.mkyong.users.service;

import java.util.Date;

public interface ProjectService {
	
	public void addProject(int id, int id_emp, int organization, int id_datamodel, Date start_date, Date finish_date);
	
}
