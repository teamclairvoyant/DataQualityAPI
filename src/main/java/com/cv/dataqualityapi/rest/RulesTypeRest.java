package com.cv.dataqualityapi.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cv.dataqualityapi.dto.CreateRuleTypeDto;
import com.cv.dataqualityapi.model.RulesType;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/rules-type")
public interface RulesTypeRest {

	@ApiOperation(value = "Create RulesType", notes = "Returns saved message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "rulesType", allowMultiple = true, dataTypeClass = CreateRuleTypeDto.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "createRulesType")
	public String createRulesType(@RequestBody List<CreateRuleTypeDto> createRuleTypeDto) throws Exception;

	@ApiOperation(value = "Get all the Clients", notes = "No input params are required", response = RulesType.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Getting list of Clients"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@GetMapping(value = "getRulesType")
	public List<RulesType> getRulesType();

	@ApiOperation(value = "Delete RulesType", notes = "Returns deleted message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "rulesType", dataTypeClass = RulesType.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "deleteRulesType")
	public String deleteRulesType(@RequestBody RulesType rulesType) throws Exception;

	@ApiOperation(value = "Update RulesType", notes = "Returns updated message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "rulesType", allowMultiple = false, dataTypeClass = RulesType.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "updateRulesType")
	public String updateRulesType(@RequestBody RulesType rulesType) throws Exception;
	
	@ApiOperation(value = "Get all the RulesType", notes = "Returns RulesType based on the page size", response = RulesType.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Getting list of RulesetFrequency"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "pageNo", allowMultiple = false, dataTypeClass = Integer.class, value = "Passed as Query param", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", allowMultiple = false, dataTypeClass = Integer.class, value = "Passed as Query param", paramType = "query", required = false),
			@ApiImplicitParam(name = "sortBy", allowMultiple = false, dataTypeClass = String.class, value = "Passed as Query param", paramType = "query", required = false) })
	@GetMapping(value = "getAllRulesType")
	public List<RulesType> getAllRulesType(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "rulesetId") String sortBy);

	@ApiOperation(value = "Get all the RulesType by ids", notes = "Returns RulesType for the passed ids", response = RulesType.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Getting list of RulesetType"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "ids", allowMultiple = true, dataTypeClass = Integer.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "getRulesTypeByIds")
	public List<RulesType> getRulesTypeByIds(@RequestBody List<Integer> ids);

}
