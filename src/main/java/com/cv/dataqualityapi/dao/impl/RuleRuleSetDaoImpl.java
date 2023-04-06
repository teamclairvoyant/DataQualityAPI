package com.cv.dataqualityapi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cv.dataqualityapi.dao.RuleRuleSetDao;
import com.cv.dataqualityapi.model.RuleRuleSet;

public class RuleRuleSetDaoImpl implements RuleRuleSetDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<RuleRuleSet> getRulesByRuleSetId(Integer rulesetId) {
		TypedQuery<RuleRuleSet> createNamedQuery = entityManager.createNamedQuery("RuleRuleSet.getRulesByRuleSetId", RuleRuleSet.class);
		createNamedQuery.setParameter("rulesetId", rulesetId);
		return createNamedQuery.getResultList();
	}

}
