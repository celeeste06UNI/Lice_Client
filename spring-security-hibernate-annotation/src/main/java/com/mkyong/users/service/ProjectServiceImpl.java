package com.mkyong.users.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public void addProject(int id, int id_emp, int id_org, int id_datamodel, Date start_date, Date finish_date) {
		String url = rutaServidor + "/project/saveProject?" + "id=" + id + "&id_emp="
				+ id_emp + "&id_org=" + id_org + "&id_datamodel=" + id_datamodel + "&start_date="
				+ start_date + "&finish_date=" + finish_date;

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);
		
	}
	
	

}
