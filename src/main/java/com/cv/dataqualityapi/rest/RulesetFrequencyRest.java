package com.cv.dataqualityapi.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cv.dataqualityapi.model.RulesetFrequency;
import com.cv.dataqualityapi.wrapper.RulesetFrequencyWrapper;

@RequestMapping("/RulesetFrequency")
public interface RulesetFrequencyRest {

	@GetMapping(value = "getRulesetFrequency")
	public List<RulesetFrequency> getRulesetFrequency();

	@PostMapping(value = "createRulesetFrequency")
	public String createRulesetFrequency(@RequestBody List<RulesetFrequencyWrapper> rulesetFrequency) throws Exception;

	@PostMapping(value = "deleteRulesetFrequency")
	public String deleteRulesetFrequency(@RequestBody List<Integer> freqIds) throws Exception;

	@PostMapping(value = "updateRulesetFrequency")
	public String updateRulesetFrequency(List<RulesetFrequencyWrapper> rulesetFrequency) throws Exception;

}
