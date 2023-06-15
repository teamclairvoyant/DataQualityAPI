package com.cv.dataqualityapi.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cv.dataqualityapi.dto.EntityDetailsDto;
import com.cv.dataqualityapi.model.EntityDetails;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/entity-details")
@RequestMapping("/entity-details")
public interface EntityDetailsRest {

	@ApiOperation(value = "Insert Entity Details", notes = "Returns saved message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "entityDetails", allowMultiple = true, dataTypeClass = EntityDetails.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping
	String save(@RequestBody EntityDetailsDto dto);

	@ApiOperation(value = "Get the Entity Details by id", notes = "Returns Entity Details for the passed id", response = EntityDetails.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Getting list of Entity Details"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@GetMapping("/{id}")
	EntityDetails findById(@PathVariable Integer id);

	@ApiOperation(value = "Get all the entity details", notes = "No input params are required", response = EntityDetails.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Getting list of entity details"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@GetMapping
	List<EntityDetails> findAll();
	
	
	@ApiOperation(value = "update Entity Details", notes = "Returns saved message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "entityDetails", allowMultiple = true, dataTypeClass = EntityDetails.class, value = "The body is a json", paramType = "body", required = true) })
	@PutMapping("/{id}")
	EntityDetails update(@RequestBody EntityDetailsDto dto,@PathVariable Integer id);

	
	@ApiOperation(value = "Delete Entity Details", notes = "Returns deleted message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Deleted"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@DeleteMapping("/{id}")
	String delete(Integer id);

}
