package com.cv.dataqualityapi.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cv.dataqualityapi.model.Clients;

@RequestMapping("/Client")

public interface ClientRest {

	@PostMapping(value = "insertClients")
	public String insertClients(@RequestBody Clients clients);
	
}
