package com.mkyong.users.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkyong.users.model.Attribute;
import com.mkyong.users.model.Organization;
import com.mkyong.users.model.Rule;
import com.mkyong.users.model.RuleProj;
import com.mkyong.users.model.RuleProjCatalogue;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@Service
@Transactional
public class RuleServiceImpl implements RuleService {

	String rutaServidor = "http://localhost:8080/SpringSecurityServer";

	@Transactional
	public void addRule(Rule rule) {
		String url = rutaServidor + "/rule/addRule?" + "id_rule=" + rule.getId_rule() + "&property="
				+ rule.getProperty() + "&state=" + rule.getState() + "&criticity=" + rule.getCriticity() + "&priority="
				+ rule.getPriority() + "&version=" + rule.getVersion();

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);

	}

	@Transactional
	public void addRuleProj(RuleProj ruleProj) {
		String url = rutaServidor + "/rule/addRuleProj?" + "id_rule=" + ruleProj.getId_rule() + "&id_project="
				+ ruleProj.getId_project();

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);

	}

	@Transactional
	public void addAttribute(Attribute attribute) {
		String url = rutaServidor + "/rule/addAttribute?" + "id_attribute=" + attribute.getId_attribute() + "&id_rule="
				+ attribute.getId_rule() + "&modal_operator=" + attribute.getModal_operator() + "&term="
				+ attribute.getTerm() + "&verb=" + attribute.getVerb() + "&logical_operator="
				+ attribute.getLogical_operator() + "&term_value=" + attribute.getTerm_value();

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);

	}

	@Transactional
	public void addRuleProjCatalogue(RuleProjCatalogue ruleProjCatalogue) {
		String url = rutaServidor + "/rule/addRuleProjCatalogue?" + "id_rule=" + ruleProjCatalogue.getId_rule()
				+ "&id_project=" + ruleProjCatalogue.getId_project() + "&id_catalogue="
				+ ruleProjCatalogue.getId_catalogue();

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);

	}

	@Transactional
	public Rule getLastRule() {
		String url = rutaServidor + "/rule/getLastRule";
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		Rule rule = new Rule();
		List<Rule> list = new ArrayList<Rule>();
		ObjectMapper mapper = new ObjectMapper();

		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), Rule[].class));
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < list.size(); i++) {
			rule = list.get(i);
		}

		return rule;
	}

}
