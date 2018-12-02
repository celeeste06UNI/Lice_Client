package com.mkyong.users.service;

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
public class CatalogueServiceImpl implements CatalogueService{
	
	String rutaServidor = "http://localhost:8080/SpringSecurityServer";

	@Transactional
	public void addCatalogue(int id_catalogue, String name, String description) {
		String url = rutaServidor + "/catalogue/addCatalogue?" + "id_catalogue=" + id_catalogue 
				+ "&name=" + name + "&description=" + description;
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);
		
	}

}
