package com.cv.dataqualityapi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cv.dataqualityapi.dao.RulesDao;
import com.cv.dataqualityapi.model.Rules;

public class RulesDaoImpl implements RulesDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Rules> getAllRulesPks() {
		TypedQuery<Rules> createNamedQuery = entityManager.createNamedQuery("Rules.getAllRulesPks", Rules.class);
		return createNamedQuery.getResultList();
	}

}
