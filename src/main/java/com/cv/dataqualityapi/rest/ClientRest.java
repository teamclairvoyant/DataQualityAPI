package com.cv.dataqualityapi.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cv.dataqualityapi.model.Clients;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/Client")
@RequestMapping("/Client")
public interface ClientRest {

	@ApiOperation(value = "Get all the Clients", notes = "No input params are required", response = Clients.class, responseContainer = "List")
	@GetMapping(value = "getClients")
	public List<Clients> getClients();

	@PostMapping(value = "insertClients")
	public String insertClients(@RequestBody Clients clients) throws Exception;

	@PostMapping(value = "deleteClients")
	public String deleteClients(@RequestBody Clients clients) throws Exception;

	@PostMapping(value = "updateClients")
	String updateClients(@RequestBody Clients clients) throws Exception;

}
