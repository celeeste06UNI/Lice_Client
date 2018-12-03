package com.mkyong.users.service;

import com.mkyong.users.model.Attribute;
import com.mkyong.users.model.Rule;
import com.mkyong.users.model.RuleProj;
import com.mkyong.users.model.RuleProjCatalogue;

public interface RuleService {
	
	public void addRule(Rule rule);
	
	public Rule getLastRule();
	
	public void addRuleProj(RuleProj ruleProj);
	
	public void addAttribute(Attribute attribute);
	
	public void addRuleProjCatalogue(RuleProjCatalogue ruleProjCatalogue);
	

}
