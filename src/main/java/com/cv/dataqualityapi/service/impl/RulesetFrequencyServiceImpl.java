package com.cv.dataqualityapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cv.dataqualityapi.constants.DataQualityContants;
import com.cv.dataqualityapi.dao.RuleSetRepository;
import com.cv.dataqualityapi.dao.RulesetFrequencyRepository;
import com.cv.dataqualityapi.exception.BusinessException;
import com.cv.dataqualityapi.model.RuleSet;
import com.cv.dataqualityapi.model.RulesetFrequency;
import com.cv.dataqualityapi.service.RulesetFrequencyService;
import com.cv.dataqualityapi.wrapper.RulesetFrequencyWrapper;

@Service
public class RulesetFrequencyServiceImpl implements RulesetFrequencyService {

	@Autowired
	private RulesetFrequencyRepository rulesetFrequencyRepository;

	@Autowired
	private RuleSetRepository ruleSetRepository;

	@Override
	public List<RulesetFrequency> getRulesetFrequency() {
		return rulesetFrequencyRepository.findAll();
	}

	@Override
	public String createRulesetFrequency(List<RulesetFrequencyWrapper> rulesetFrequency) throws Exception {
		List<RulesetFrequency> mapRulesetFreqWrapperRulesetFreq = mapRulesetFreqWrapperRulesetFreq(rulesetFrequency);
		rulesetFrequencyRepository.saveAll(mapRulesetFreqWrapperRulesetFreq);
		return DataQualityContants.SAVED;
	}

	private List<RulesetFrequency> mapRulesetFreqWrapperRulesetFreq(
			List<RulesetFrequencyWrapper> rulesetFrequencyWrapperList) throws Exception {
		ArrayList<RulesetFrequency> rulesetFrequencyList = new ArrayList<>();
		for (RulesetFrequencyWrapper rulesetFrequencyWrapper : rulesetFrequencyWrapperList) {
			RulesetFrequency rulesetFrequency = new RulesetFrequency();
			if (rulesetFrequencyWrapper.getFreqId() != null)
				rulesetFrequency.setFreqId(rulesetFrequencyWrapper.getFreqId());

			RuleSet existsByRuleSetName = ruleSetRepository
					.getRuleSetByRuleSetName(rulesetFrequencyWrapper.getRuleSetName());
			if (existsByRuleSetName == null)
				throw new BusinessException("Rule set is not present");

			rulesetFrequency.setFrequency(rulesetFrequencyWrapper.getFrequency());

			rulesetFrequency
					.setRuleSet(ruleSetRepository.getRuleSetByRuleSetName(rulesetFrequencyWrapper.getRuleSetName()));

			rulesetFrequencyList.add(rulesetFrequency);
		}
		return rulesetFrequencyList;
	}

	@Override
	public String deleteRulesetFrequency(List<Integer> freqIds) {
		rulesetFrequencyRepository.deleteAllById(freqIds);
		return DataQualityContants.DELETED;
	}

	@Override
	public String updateRulesetFrequency(List<RulesetFrequencyWrapper> rulesetFrequency) throws Exception {
		List<RulesetFrequency> mapRulesetFreqWrapperRulesetFreq = mapRulesetFreqWrapperRulesetFreq(rulesetFrequency);
		rulesetFrequencyRepository.saveAll(mapRulesetFreqWrapperRulesetFreq);
		return DataQualityContants.UPDATED;
	}

	@Override
	public List<RulesetFrequency> getAllRulesetFrequency(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<RulesetFrequency> pagedResult = rulesetFrequencyRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<RulesetFrequency>();
		}
	}

	@Override
	public List<RulesetFrequency> getRulesetFrequencyByIds(List<Integer> ids) {
		List<RulesetFrequency> findAllById = rulesetFrequencyRepository.findAllById(ids);
		return findAllById;
	}
}
