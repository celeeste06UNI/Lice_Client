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
		String operator = URLEncoder.encode(rule.getOperator());
		String property = URLEncoder.encode(rule.getProperty());
		String state = URLEncoder.encode(rule.getState());
		String criticity = URLEncoder.encode(rule.getCriticity());
		String priority = URLEncoder.encode(rule.getPriority());
		String version = URLEncoder.encode(rule.getVersion());

		String url = rutaServidor + "/rule/addRule?" + "id_rule=" + rule.getId_rule() + "&operator=" + operator
				+ "&property=" + property + "&state=" + state + "&criticity=" + criticity + "&priority=" + priority
				+ "&version=" + version;

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

		String modal_operator = URLEncoder.encode(attribute.getModal_operator());
		String term = URLEncoder.encode(attribute.getTerm());
		String verb = URLEncoder.encode(attribute.getVerb());
		String logical_operator = URLEncoder.encode(attribute.getLogical_operator());
		String term_value = URLEncoder.encode(attribute.getTerm_value());

		String url = rutaServidor + "/rule/addAttribute?" + "id_attribute=" + attribute.getId_attribute() + "&id_rule="
				+ attribute.getId_rule() + "&modal_operator=" + modal_operator + "&term=" + term + "&verb=" + verb
				+ "&logical_operator=" + logical_operator + "&term_value=" + term_value;

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

		rule = list.get(0);
		
		return rule;
	}

	@Transactional
	public List<Rule> getAllRule() {
		String url = rutaServidor + "/rule/getAllRule";
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
		return list;

	}

	@Transactional
	public List<Attribute> getAttributesByRule(int id_rule) {
		String url = rutaServidor + "/rule/getAttributesByRule?" + "id_rule=" + id_rule;
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);

		List<Attribute> list = new ArrayList<Attribute>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			list = Arrays.asList(mapper.readValue(response.getEntityInputStream(), Attribute[].class));
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
	public void deleteRule(int id_rule) {
		String url = rutaServidor + "/rule/deleteRule?" + "id_rule=" + id_rule;

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);
		
	}
	
	@Transactional
	public void updateRule(int id_rule, String operator, String property, String state, String criticity,
			String priority, String version, int id_catalogue) {
		String operator1 = URLEncoder.encode(operator);
		String property1 = URLEncoder.encode(property);
		String state1 = URLEncoder.encode(state);
		String criticity1 = URLEncoder.encode(criticity);
		String priority1 = URLEncoder.encode(priority);
		String version1 = URLEncoder.encode(version);
		
		String url = rutaServidor + "/rule/updateRule?" + "id_rule=" + id_rule + "&operator=" + operator1
				+ "&property=" + property1 + "&state=" + state1 + "&criticity=" + criticity1 + "&priority=" + priority1
				+ "&version=" + version1 + "&id_catalogue=" + id_catalogue;

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.post(ClientResponse.class);
		
		
	}

}
