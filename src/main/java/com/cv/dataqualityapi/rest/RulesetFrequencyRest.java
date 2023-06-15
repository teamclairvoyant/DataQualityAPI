package com.cv.dataqualityapi.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cv.dataqualityapi.model.RulesetFrequency;
import com.cv.dataqualityapi.wrapper.RulesetFrequencyWrapper;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/ruleset-frequency")
public interface RulesetFrequencyRest {

	@ApiOperation(value = "Get all the RulesetFrequency", notes = "No input params are required", response = RulesetFrequency.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Getting list of RulesetFrequency"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@GetMapping(value = "getRulesetFrequency")
	public List<RulesetFrequency> getRulesetFrequency();

	@ApiOperation(value = "Create RulesetFrequency", notes = "Returns saved message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "rulesetFrequencyWrapper", dataTypeClass = RulesetFrequencyWrapper.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "createRulesetFrequency")
	public String createRulesetFrequency(@RequestBody List<RulesetFrequencyWrapper> rulesetFrequencyWrapper) throws Exception;

	
	@ApiOperation(value = "Delete RulesetFrequency", notes = "Returns deleted message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "freqIds", allowMultiple = true, dataTypeClass = Integer.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "deleteRulesetFrequency")
	public String deleteRulesetFrequency(@RequestBody List<Integer> freqIds) throws Exception;

	@ApiOperation(value = "Update RulesetFrequency", notes = "Returns updated message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "rulesetFrequencyWrapper", dataTypeClass = RulesetFrequencyWrapper.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "updateRulesetFrequency")
	public String updateRulesetFrequency(List<RulesetFrequencyWrapper> rulesetFrequencyWrapper) throws Exception;
	
	@ApiOperation(value = "Get all the RulesetFrequency", notes = "Returns RulesetFrequency based on the page size", response = RulesetFrequency.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Getting list of RulesetFrequency"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "pageNo", allowMultiple = false, dataTypeClass = Integer.class, value = "Passed as Query param", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", allowMultiple = false, dataTypeClass = Integer.class, value = "Passed as Query param", paramType = "query", required = false),
			@ApiImplicitParam(name = "sortBy", allowMultiple = false, dataTypeClass = String.class, value = "Passed as Query param", paramType = "query", required = false) })
	@GetMapping(value = "getAllRulesetFrequency")
	public List<RulesetFrequency> getAllRulesetFrequency(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "rulesetId") String sortBy);

	@ApiOperation(value = "Get all the RulesetFrequency by ids", notes = "Returns rule for the passed ids", response = RulesetFrequency.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Getting list of RulesetFrequency"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "ids", allowMultiple = true, dataTypeClass = Integer.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "getRulesetFrequencyByIds")
	public List<RulesetFrequency> getRulesetFrequencyByIds(@RequestBody List<Integer> ids);
}
