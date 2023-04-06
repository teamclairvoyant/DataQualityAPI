package com.cv.dataqualityapi.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.wrapper.RuleRuleSetWrapper;
import com.cv.dataqualityapi.wrapper.RuleSetWrapper;

@RequestMapping("RuleSet")
public interface RuleSetRest {

	@PostMapping(value = "createRuleSet")
	public String createRuleSet(@RequestBody List<RuleSetWrapper> ruleSetWrapper) throws Exception;
	
	@PostMapping(value = "deleteRuleSet")
	public String deleteRuleSet(@RequestBody List<Integer> ruleSetId) throws Exception;
	
	@PostMapping(value = "tagRulesToRuleSet")
	public String tagRulesToRuleSet(@RequestBody List<RuleRuleSetWrapper> ruleRuleSetWrapper) throws Exception;
	
	@PostMapping(value = "untagRulesToRuleSet")
	public String untagRulesToRuleSet(@RequestBody List<RuleRuleSetWrapper> ruleRuleSetWrapper) throws Exception;

	@GetMapping(value = "getRulesByRuleSetId")
	public List<Rules> getRulesByRuleSetId(@RequestParam Integer rulesetId) throws Exception;
}
