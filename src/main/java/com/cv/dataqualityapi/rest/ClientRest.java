package com.cv.dataqualityapi.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cv.dataqualityapi.model.Clients;

@RequestMapping("/Client")
public interface ClientRest {

	@GetMapping(value = "getClients")
	public List<Clients> getClients();

	@PostMapping(value = "insertClients")
	public String insertClients(@RequestBody Clients clients) throws Exception;

	@PostMapping(value = "deleteClients")
	public String deleteClients(@RequestBody Clients clients) throws Exception;

	@PostMapping(value = "updateClients")
	String updateClients(@RequestBody Clients clients) throws Exception;

}
