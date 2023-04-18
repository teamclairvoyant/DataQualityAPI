package com.cv.dataqualityapi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cv.dataqualityapi.dao.RulesDao;
import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.wrapper.RulesWrapper;

public class RulesDaoImpl implements RulesDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Rules> getAllRulesPks() {
		TypedQuery<Rules> createNamedQuery = entityManager.createNamedQuery("Rules.getAllRulesPks", Rules.class);
		return createNamedQuery.getResultList();
	}

//UPPER(rt.typeName) = UPPER(:typeName) and UPPER(r.ruleDesc) = UPPER(:ruleDesc) and 
	// UPPER(r.tableName) = UPPER(:tableName) and UPPER(r.columnName) =
	// UPPER(columnName) and
	// UPPER(r.columnValue) = UPPER(:columnValue) and UPPER(r.sourceName) =
	// UPPER(sourceName) and
	// UPPER(c.clientName) = UPPER(:clientName)
	@Override
	public Boolean isRulePresent(RulesWrapper rulesWrapper) {
		TypedQuery<Long> createNamedQuery = entityManager.createNamedQuery("Rules.getRuleCount", Long.class);
//		createNamedQuery.setParameter("ruleId", rulesWrapper.getRuleId());
		createNamedQuery.setParameter("typeName", rulesWrapper.getTypeName());
		createNamedQuery.setParameter("ruleDesc", rulesWrapper.getRuleDesc());
		createNamedQuery.setParameter("tableName", rulesWrapper.getTableName());
		createNamedQuery.setParameter("columnName", rulesWrapper.getColumnName());
		createNamedQuery.setParameter("columnValue", rulesWrapper.getColumnValue());
		createNamedQuery.setParameter("sourceName", rulesWrapper.getSourceName());
		createNamedQuery.setParameter("clientName", rulesWrapper.getClientName());
		return createNamedQuery.getSingleResult().intValue() > 0 ? true : false;
	}

	@Override
	public Rules getRules(RulesWrapper rulesWrapper) {
		TypedQuery<Rules> createNamedQuery = entityManager.createNamedQuery("Rules.getRules", Rules.class);
		createNamedQuery.setParameter("typeName", rulesWrapper.getTypeName());
		createNamedQuery.setParameter("ruleDesc", rulesWrapper.getRuleDesc());
		createNamedQuery.setParameter("tableName", rulesWrapper.getTableName());
		createNamedQuery.setParameter("columnName", rulesWrapper.getColumnName());
		createNamedQuery.setParameter("columnValue", rulesWrapper.getColumnValue());
		createNamedQuery.setParameter("sourceName", rulesWrapper.getSourceName());
		createNamedQuery.setParameter("clientName", rulesWrapper.getClientName());
		try {
			return createNamedQuery.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

}
