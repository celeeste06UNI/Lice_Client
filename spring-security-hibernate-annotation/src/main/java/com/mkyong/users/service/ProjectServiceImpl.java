package com.mkyong.users.service;



import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkyong.users.model.Organization;
import com.mkyong.users.model.Personal;
import com.mkyong.users.model.Project;
import com.mkyong.users.model.ProjectForView;
import com.mkyong.users.model.RuleProj;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{
	
	String rutaServidor = "http://localhost:8080/SpringSecurityServer";
	
	@Transactional
	public void addProject(int id, String proj_name, int id_emp, int id_org, int id_datamodel, Date start_date, Date finish_date) {
		String url = rutaServidor + "/project/saveProject?" + "id=" + id + "&proj_name="+ proj_name + "&id_emp="
				+ id_emp + "&id_org=" + id_org + "&id_datamodel=" + id_datamodel + "&start_date="
				+ start_date + "&finish_date=" + finish_date;

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);
		
	}

	public List<ProjectForView> getOpenProjectForView() {
		String url = rutaServidor + "/project/getOpenProjectForView";
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		List<ProjectForView> list = new ArrayList<ProjectForView>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), ProjectForView[].class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Project> getOpenProject() {
		String url = rutaServidor + "/project/getOpenProject";
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		List<Project> list = new ArrayList<Project>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), Project[].class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ProjectForView> getCloseProjectForView() {
		String url = rutaServidor + "/project/getCloseProjectForView";
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		List<ProjectForView> list = new ArrayList<ProjectForView>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), ProjectForView[].class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Project getProject(Integer id_project) {
		String url = rutaServidor + "/project/getProject?" + "id=" + id_project;
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		Project project = new Project();
		List<Project> list = new ArrayList<Project>();
		ObjectMapper mapper = new ObjectMapper();

		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), Project[].class));
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < list.size(); i++) {
			project = list.get(i);
		}

		return project;
	}

	@Override
	public Integer getProjectByRule(int id_rule) {
		String url = rutaServidor + "/project/getProjectByRule?" + "id_rule=" + id_rule;
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		RuleProj project = new RuleProj();
		List<RuleProj> list = new ArrayList<RuleProj>();
		ObjectMapper mapper = new ObjectMapper();

		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), RuleProj[].class));
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



		return list.get(0).getId_project();
	}
	
	

}
