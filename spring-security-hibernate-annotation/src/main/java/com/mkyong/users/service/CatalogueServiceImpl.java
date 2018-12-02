package com.mkyong.users.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkyong.users.model.Catalogue;
import com.mkyong.users.model.Organization;
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
	
	@Transactional
	public List<Catalogue> getAllCatalogue() {
		String url = rutaServidor + "/catalogue/getAllCatalogue";
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		List<Catalogue> list = new ArrayList<Catalogue>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), Catalogue[].class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

}
