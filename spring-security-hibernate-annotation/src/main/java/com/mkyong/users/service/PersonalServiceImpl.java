package com.mkyong.users.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkyong.users.dao.PersonalDao;
import com.mkyong.users.model.Personal;
import com.mkyong.users.model.User;
import com.mkyong.users.model.UserRole;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@Service
@Transactional
public class PersonalServiceImpl implements PersonalService {

	String rutaServidor = "http://localhost:8080/SpringSecurityServer";
	@Autowired
	private PersonalDao personalDao;

	@Transactional
	public void addPersonal(Personal personal) {
		String url = rutaServidor + "/personal/savePersonal?" + "id=" + personal.getId() + "&username="
				+ personal.getUsername() + "&name=" + personal.getName() + "&email=" + personal.getEmail() + "&address="
				+ personal.getAddress() + "&telephone=" + personal.getTelephone();

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);
	}

	@Transactional
	public void updatePersonal(Personal personal) {
		String url = rutaServidor + "/personal/updatePersonal?" + "id=" + personal.getId() + "&username="
				+ personal.getUsername() + "&name=" + personal.getName() + "&email=" + personal.getEmail() + "&address="
				+ personal.getAddress() + "&telephone=" + personal.getTelephone();

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);
	}
	
	@Transactional
	public List<Personal> getAllPersonal() {
		String url = rutaServidor + "/personal/getAllPersonal";
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		List<Personal> list = new ArrayList<Personal>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), Personal[].class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addUser(User user) {
		String url = rutaServidor + "/personal/saveUser?" + "username=" + user.getUsername() + "&password="
				+ user.getPassword() + "&enabled=" + user.isEnabled();

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);
	}

	public void addUserRole(User user, String rol) {
		String url = rutaServidor + "/personal/saveUserRole?" + "username=" + user.getUsername() + "&password="
				+ user.getPassword() + "&enabled=" + user.isEnabled() + "&role=" + rol;

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);

	}

	public void deletePersonal(Integer id) {
		// personalDao.deleteUser(userId);
		String url = rutaServidor + "/personal/deletePersonal?" + "id=" + id;

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);
	}

	public void deleteUser(String username) {
		String url = rutaServidor + "/personal/deleteUser?" + "username=" + username;

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);

	}

	public void updatePersonal(Integer id) {
		String url = rutaServidor + "/personal/updatePersonal?" + "id=" + id;

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);

	}

	public Personal getPersonal(Integer id) {
		String url = rutaServidor + "/personal/getPersonal?" + "id=" + id;
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);
		
		Personal personal = new Personal();
		List<Personal> list = new ArrayList<Personal>();
		ObjectMapper mapper = new ObjectMapper();

		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), Personal[].class));
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < list.size(); i++) {
			personal = list.get(i);
		}

		return personal;
	}

	/*
	 * public User getUser(int userId) { return userDao.getUser(userId); }
	 * 
	 * public User updateUser(User user) { // TODO Auto-generated method stub return
	 * userDao.updateUser(user); }
	 * 
	 * public void setEmployeeDAO(UserDao userDao) { this.userDao = userDao; }
	 */

}
