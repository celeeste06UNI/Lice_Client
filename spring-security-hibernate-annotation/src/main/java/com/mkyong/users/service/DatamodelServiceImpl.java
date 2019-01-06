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
import com.mkyong.users.model.DataModelDecript;
import com.mkyong.users.model.Organization;
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
	
	@Transactional
	public List<String> getdmdByIdDatamodel(Integer id_datamodel) {
		String url = rutaServidor + "/datam/getdmdByIdDatamodel?"+ "id_datamodel=" + id_datamodel;
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
	
	@Transactional
	public List<String> getAttributesByTable(String table_name) {
		String url = rutaServidor + "/datam/getAttributesByTable?"+ "table_name=" + table_name;
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
	@Transactional
	public void deleteDataModel(String database_name, String version) {
		String url = rutaServidor + "/datam/deleteDataModel?"
				+ "database_name=" + database_name
				+ "&version=" + version;
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);
		
	}
	
	public DataModel getDataModel(Integer id) {
		String url = rutaServidor + "/datam/getDataModel?" + "id_dm=" + id;
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		DataModel dataModel = new DataModel();
		List<DataModel> list = new ArrayList<DataModel>();
		ObjectMapper mapper = new ObjectMapper();

		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), DataModel[].class));
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < list.size(); i++) {
			dataModel = list.get(i);
		}

		return dataModel;
	}

	public List<DataModelDecript> getDatamodelDescript(int id_datamodel) {
		String url = rutaServidor + "/datam/getDatamodelDescript?" + "id_datamodel=" + id_datamodel;
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		List<DataModelDecript> list = new ArrayList<DataModelDecript>();
		ObjectMapper mapper = new ObjectMapper();

		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), DataModelDecript[].class));
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public List<String> getNameTableDescript(int id_datamodel) {
		String url = rutaServidor + "/datam/getNameTableDescript?" + "id_datamodel=" + id_datamodel;
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
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}


}
