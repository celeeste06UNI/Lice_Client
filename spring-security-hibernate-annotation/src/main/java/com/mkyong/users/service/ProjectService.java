
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

	public Project getProject(Integer id_project);

	public Integer getProjectByRule(int id_rule);

	public List<ProjectForView> getOpenProjectUserForView(String username);

	public List<ProjectForView> getCloseProjectUserForView(String username);

	public List<Project> getOpenProjectUser(String username);
	
}

