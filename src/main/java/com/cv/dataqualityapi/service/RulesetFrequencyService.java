package com.cv.dataqualityapi.service;

import java.util.List;

import com.cv.dataqualityapi.model.RulesetFrequency;
import com.cv.dataqualityapi.wrapper.RulesetFrequencyWrapper;

public interface RulesetFrequencyService {

	List<RulesetFrequency> getRulesetFrequency();

	String createRulesetFrequency(List<RulesetFrequencyWrapper> rulesetFrequency) throws Exception;

	String deleteRulesetFrequency(List<Integer> freqIds);

	String updateRulesetFrequency(List<RulesetFrequencyWrapper> rulesetFrequency) throws Exception;

}
