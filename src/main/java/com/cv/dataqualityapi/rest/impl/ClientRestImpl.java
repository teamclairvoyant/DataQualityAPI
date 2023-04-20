package com.cv.dataqualityapi.rest.impl;

import java.util.List;

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
	public List<Clients> getClients() {
		return clientService.getClients();
	}

	@Override
	public String insertClients(Clients clients) throws Exception {
		log.info("Test Logger : {}", clients);
		return clientService.insertClients(clients);
	}

	@Override
	public String deleteClients(Clients clients) throws Exception {
		return clientService.deleteClients(clients);
	}

	@Override
	public String updateClients(Clients clients) throws Exception {
		log.info("Test Logger", clients);
		return clientService.updateClients(clients);
	}

	@Override
	public List<Clients> getAllClients(Integer pageNo, Integer pageSize, String sortBy) {
		return clientService.getAllClients(pageNo, pageSize, sortBy);
	}
	
	@Override
	public List<Clients> getClientsByIds(List<Integer> ids) {
		log.debug("Going to get all the Clients of ids : {}", ids);
		return clientService.getClientsByIds(ids);
	}

}
