package com.mkyong.users.service;

import java.util.List;

import com.mkyong.users.model.Attribute;
import com.mkyong.users.model.Rule;
import com.mkyong.users.model.RuleProj;
import com.mkyong.users.model.RuleProjCatalogue;

public interface RuleService {

	public void addRule(Rule rule);

	public Rule getLastRule();

	public List<Rule> getAllRule();
	
	public Rule getRule(int id_rule);
	
	public List<RuleProj> getRulesByProject(int id_project);

	public void deleteRule(int id_rule);

	public void updateRule(int id_rule, String operator, String property, String state, String criticity,
			String priority, String version, int id_catalogue);

	public void addRuleProj(RuleProj ruleProj);

	public void addAttribute(Attribute attribute);

	public List<Attribute> getAttributesByRule(int id_rule);

	public void addRuleProjCatalogue(RuleProjCatalogue ruleProjCatalogue);

}
