package com.cv.dataqualityapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dataqualityapi.dao.ClientDao;
import com.cv.dataqualityapi.model.Clients;
import com.cv.dataqualityapi.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientDao;

	@Override
	public String insertClients(Clients clients) {
		clientDao.save(clients);
		return "Saved";
	}

	

}
