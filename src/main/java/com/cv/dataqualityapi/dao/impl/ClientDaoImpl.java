package com.cv.dataqualityapi.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cv.dataqualityapi.dao.ClientDao;
import com.cv.dataqualityapi.model.Clients;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientDaoImpl implements ClientDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Clients getClientByClientName(String clientName) {
		TypedQuery<Clients> createNamedQuery = entityManager.createNamedQuery("Clients.getClientByClientName",
				Clients.class);
		createNamedQuery.setParameter("clientName", clientName);
		return createNamedQuery.getSingleResult();
	}

	@Override
	public Integer getClientCountByClientName(String clientName) {
		TypedQuery<Long> createNamedQuery = entityManager.createNamedQuery("Clients.getClientCountByClientName",
				Long.class);
		createNamedQuery.setParameter("clientName", clientName);
		return createNamedQuery.getSingleResult().intValue();
	}

	@Override
	public Boolean existsByClientName(String clientName) {
		TypedQuery<Long> createNamedQuery = entityManager.createNamedQuery("Clients.getClientCountByClientName",
				Long.class);
		createNamedQuery.setParameter("clientName", clientName);
		Long singleResult = createNamedQuery.getSingleResult();
		log.info("Number of records are : {}", singleResult);
		return singleResult.intValue() > 0 ? true : false;
	}

}
