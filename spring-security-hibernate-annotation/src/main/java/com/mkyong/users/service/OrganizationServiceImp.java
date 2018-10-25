package com.mkyong.users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.users.model.Organization;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;


@Service
@Transactional
public class OrganizationServiceImp implements OrganizationService{
	
	String rutaServidor = "http://localhost:8080/SpringSecurityServer";

	@Transactional
	public void addOrganization(Organization organization) {
		String url = rutaServidor + "/organization/saveOrganization?" + "id=" + organization.getId() + "&cif=" 
	+ organization.getCif() + "&name_org=" + organization.getName_org() + "&name_trade=" + organization.getName_trade() 
				+ "&name_contact=" + organization.getName_contact() + "&role_contact=" + organization.getRole_contact() 
				+ "&telephone_contact=" + organization.getTelephone_contact();
				

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);
		
	}

}
