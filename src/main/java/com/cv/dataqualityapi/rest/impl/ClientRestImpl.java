package com.cv.dataqualityapi.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cv.dataqualityapi.model.Clients;
import com.cv.dataqualityapi.rest.ClientRest;
import com.cv.dataqualityapi.service.ClientService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class ClientRestImpl implements ClientRest {
	
	@Autowired
	private ClientService clientService;

	@Override
	public String insertClients(Clients clients) {
		log.info("Test Logger");
		return clientService.insertClients(clients);
	}

}
