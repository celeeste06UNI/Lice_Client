package com.mkyong.users.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkyong.users.model.DataModel;
import com.mkyong.users.model.Personal;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@Service
@Transactional
public class DatamodelServiceImpl implements DatamodelService{
	
	String rutaServidor = "http://localhost:8080/SpringSecurityServer";
	
	@Transactional
	public void upload(String path, String sistemabbdd, String version) {
		String url = rutaServidor + "/datam/uploadFile?" + "path=" + path
				+ "&sistemabbdd=" + sistemabbdd
				+ "&version=" + version;
		
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);
		
	}

	@Transactional
	public List<DataModel> getAllDatamodel() {
		String url = rutaServidor + "/datam/getAllDatamodel";
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		List<DataModel> list = new ArrayList<DataModel>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), DataModel[].class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Transactional
	public List<String> getAllNameDatamodel() {
		String url = rutaServidor + "/datam/getAllNameDatamodel";
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		List<String> list = new ArrayList<String>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), String[].class));
			//list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), String[].class));
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
