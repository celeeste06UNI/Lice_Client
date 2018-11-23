package com.mkyong.users.service;

import java.sql.Date;
import java.util.List;

import com.mkyong.users.model.Project;
import com.mkyong.users.model.ProjectForView;

public interface ProjectService {
	
	public void addProject(int id, String proj_name,int id_emp, int organization, int id_datamodel, Date start_date, Date finish_date);

	public List<ProjectForView> getOpenProjectForView();
	
	public List<ProjectForView> getCloseProjectForView();
	
	public List<Project> getOpenProject();
	
}
