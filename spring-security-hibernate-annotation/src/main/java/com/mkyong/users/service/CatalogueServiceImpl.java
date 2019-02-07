package com.mkyong.users.service;

import java.io.IOException;
import java.net.URLEncoder;
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
import com.mkyong.users.model.RuleProjCatalogue;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@Service
@Transactional
public class CatalogueServiceImpl implements CatalogueService {

	String rutaServidor = "http://localhost:8080/SpringSecurityServer";

	@Transactional
	public void addCatalogue(int id_catalogue, String name, String description) {
		
		
		
		String url = rutaServidor + "/catalogue/addCatalogue?" + "id_catalogue=" + id_catalogue + "&name=" + name
				+ "&description=" + URLEncoder.encode(description);
		
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

	@Transactional
	public void deleteCatalogue(Integer id_catalogue) {
		String url = rutaServidor + "/catalogue/deleteCatalogue?" + "id_catalogue=" + id_catalogue;

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);

	}

	@Transactional
	public Catalogue getCatalogue(Integer id_catalogue) {
		String url = rutaServidor + "/catalogue/getCatalogue?" + "id_catalogue=" + id_catalogue;
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		Catalogue catalogue = new Catalogue();
		List<Catalogue> list = new ArrayList<Catalogue>();
		ObjectMapper mapper = new ObjectMapper();

		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), Catalogue[].class));
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < list.size(); i++) {
			catalogue = list.get(i);
		}

		return catalogue;
	}

	public void updateCatalogue(Catalogue catalogue) {
		String url = rutaServidor + "/catalogue/updateCatalogue?" + "id_catalogue=" + catalogue.getId_catalogue()
				+ "&name=" + catalogue.getName()+ "&description="+ catalogue.getDescription();

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);

		
	}
	
	@Transactional
	public int getRuleProjCatalogue(Integer id_catalogue) {
		String url = rutaServidor + "/catalogue/getRuleProjCatalogue?" + "id_catalogue=" + id_catalogue;
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		List<RuleProjCatalogue> list = new ArrayList<RuleProjCatalogue>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), RuleProjCatalogue[].class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list.size();
	}

	@Override
	public RuleProjCatalogue getListRuleProjCatalogue(int id_rule, Integer id_project) {
		String url = rutaServidor + "/catalogue/getListRuleProjCatalogue?" + "id_rule=" + id_rule + "&id_project=" + id_project;
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		List<RuleProjCatalogue> list = new ArrayList<RuleProjCatalogue>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), RuleProjCatalogue[].class));
			System.out.println("HOLA");
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(list.isEmpty()) {
			RuleProjCatalogue rpc = new RuleProjCatalogue();
			rpc = null;
			return rpc;
		}else {
			return list.get(0);
		}
	}

	@Override
	public List<Catalogue> getCatalogues(int id_rule, Integer id_project) {
		String url = rutaServidor + "/catalogue/getCatalogues?"+ "id_rule=" + id_rule + "&id_project=" + id_project;
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
