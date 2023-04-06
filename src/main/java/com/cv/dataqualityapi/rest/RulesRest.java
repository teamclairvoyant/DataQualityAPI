package com.cv.dataqualityapi.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.wrapper.RulesWrapper;

@RequestMapping("/Rule")
public interface RulesRest {

	@PostMapping(value = "createRule")
	public String createRule(@RequestBody RulesWrapper ruleWrapper) throws Exception;

	@PostMapping(value = "createRules")
	String createRules(@RequestBody List<RulesWrapper> ruleWrapperList) throws Exception;

	@GetMapping(value = "getRules")
	public List<Rules> getRules();

	@PostMapping(value = "deleteRules")
	public String deleteRules(@RequestBody List<Integer> ids) throws Exception;

	@PostMapping(value = "updateRules")
	String updateRules(@RequestBody List<RulesWrapper> ruleWrapper) throws Exception;

}
