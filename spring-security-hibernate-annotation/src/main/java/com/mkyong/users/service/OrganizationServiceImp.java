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
public class OrganizationServiceImp implements OrganizationService {

	String rutaServidor = "http://localhost:8080/SpringSecurityServer";

	@Transactional
	public void addOrganization(Organization organization) {
		String url = rutaServidor + "/organization/saveOrganization?" + "id=" + organization.getId() + "&cif="
				+ organization.getCif() + "&name_org=" + organization.getName_org() + "&name_trade="
				+ organization.getName_trade() + "&name_contact=" + organization.getName_contact() + "&role_contact="
				+ organization.getRole_contact() + "&telephone_contact=" + organization.getTelephone_contact();

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);

	}

	@Transactional
	public List<Organization> getAllOrganization() {
		String url = rutaServidor + "/organization/getAllOrganization";
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		List<Organization> list = new ArrayList<Organization>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), Organization[].class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void deleteOrganization(Integer id) {
		String url = rutaServidor + "/organization/deleteOrganization?" + "id=" + id;

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);

	}

	public Organization getOrganization(Integer id) {
		String url = rutaServidor + "/organization/getOrganization?" + "id=" + id;
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		Organization organization = new Organization();
		List<Organization> list = new ArrayList<Organization>();
		ObjectMapper mapper = new ObjectMapper();

		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), Organization[].class));
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < list.size(); i++) {
			organization = list.get(i);
		}

		return organization;
	}

	public void updateOrganization(Organization organization) {
		String url = rutaServidor + "/organization/updateOrganization?" + "id=" + organization.getId() + "&cif="
				+ organization.getCif() + "&name_org=" + organization.getName_org() + "&name_trade="
				+ organization.getName_trade() + "&name_contact=" + organization.getName_contact() + "&role_contact="
				+ organization.getRole_contact() + "&telephone_contact=" + organization.getTelephone_contact();

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);

	}

}
