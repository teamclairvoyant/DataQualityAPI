package com.cv.dataqualityapi.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cv.dataqualityapi.model.RulesetFrequency;
import com.cv.dataqualityapi.rest.RulesetFrequencyRest;
import com.cv.dataqualityapi.service.RulesetFrequencyService;
import com.cv.dataqualityapi.wrapper.RulesetFrequencyWrapper;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class RulesetFrequencyRestImpl implements RulesetFrequencyRest{
	
	@Autowired
	private RulesetFrequencyService rulesetFrequencyService;
	
	@Override
	public List<RulesetFrequency> getRulesetFrequency() {
		return rulesetFrequencyService.getRulesetFrequency();
	}

	@Override
	public String createRulesetFrequency(List<RulesetFrequencyWrapper> rulesetFrequency) throws Exception {
		return rulesetFrequencyService.createRulesetFrequency(rulesetFrequency);
	}

	@Override
	public String deleteRulesetFrequency(List<Integer> freqIds) throws Exception {
		return rulesetFrequencyService.deleteRulesetFrequency(freqIds);
	}
	
	@Override
	public String updateRulesetFrequency(List<RulesetFrequencyWrapper> rulesetFrequency) throws Exception {
		return rulesetFrequencyService.updateRulesetFrequency(rulesetFrequency);
	}

}
