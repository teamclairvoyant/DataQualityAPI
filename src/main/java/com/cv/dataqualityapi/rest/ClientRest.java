package com.cv.dataqualityapi.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cv.dataqualityapi.model.Clients;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/client")
@RequestMapping("/client")
public interface ClientRest {

	@ApiOperation(value = "Get all the Clients", notes = "No input params are required", response = Clients.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Getting list of Clients"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@GetMapping(value = "getClients")
	public List<Clients> getClients();

	@ApiOperation(value = "Insert Clients", notes = "Returns saved message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "clients", allowMultiple = true, dataTypeClass = Clients.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "insertClients")
	public String insertClients(@RequestBody Clients clients) throws Exception;

	@ApiOperation(value = "Delete Clients", notes = "Returns deleted message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Deleted"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "clients", dataTypeClass = Clients.class, value = "The body is a json", paramType = "body", required = true), })
	@PostMapping(value = "deleteClients")
	public String deleteClients(@RequestBody Clients clients) throws Exception;

	@ApiOperation(value = "Update Clients", notes = "Returns updated message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "clients", dataTypeClass = Clients.class, value = "The body is a json", paramType = "body", required = true), })
	@PostMapping(value = "updateClients")
	public String updateClients(@RequestBody Clients clients) throws Exception;
	
	@ApiOperation(value = "Get all the Clients", notes = "Returns Clients based on the page size", response = Clients.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Getting list of Rules"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "pageNo", allowMultiple = false, dataTypeClass = Integer.class, value = "Passed as Query param", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", allowMultiple = false, dataTypeClass = Integer.class, value = "Passed as Query param", paramType = "query", required = false),
			@ApiImplicitParam(name = "sortBy", allowMultiple = false, dataTypeClass = String.class, value = "Passed as Query param", paramType = "query", required = false) })
	@GetMapping(value = "getAllClients")
	public List<Clients> getAllClients(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "clientId") String sortBy);

	@ApiOperation(value = "Get all the Clients by ids", notes = "Returns Clients for the passed ids", response = Clients.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Getting list of Clients"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "ids", allowMultiple = true, dataTypeClass = Integer.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "getClientsByIds")
	public List<Clients> getClientsByIds(@RequestBody List<Integer> ids);
}
