package com.cv.dataqualityapi.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.wrapper.RulesWrapper;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/Rule")
public interface RulesRest {

	@ApiOperation(value = "Create Rule", notes = "Returns saved message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "ruleWrapper", dataTypeClass = RulesWrapper.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "createRule")
	public String createRule(@RequestBody RulesWrapper ruleWrapper) throws Exception;

	@ApiOperation(value = "Create Rules", notes = "Returns saved message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found"),
			@ApiResponse(code = 406, message = "Not Acceptable")})
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "ruleWrapper", allowMultiple = true, dataTypeClass = RulesWrapper.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "createRules")
	String createRules(@RequestBody List<RulesWrapper> ruleWrapper) throws Exception;

	@ApiOperation(value = "Get all the Rules", notes = "No input params are required", response = Rules.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Getting list of Rules"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@GetMapping(value = "getRules")
	public List<Rules> getRules();

	@ApiOperation(value = "Delete Rule", notes = "Returns saved message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Deleted"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "ids", allowMultiple = true, dataTypeClass = Integer.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "deleteRules")
	public String deleteRules(@RequestBody List<Integer> ids) throws Exception;

	@ApiOperation(value = "Updates Rule", notes = "Returns update message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "ruleWrapper", allowMultiple = true, dataTypeClass = RulesWrapper.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "updateRules")
	public String updateRules(@RequestBody List<RulesWrapper> ruleWrapper) throws Exception;

	@ApiOperation(value = "Get all the Rules", notes = "Returns rule for the passed id", response = Rules.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Getting list of Rules"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "id", allowMultiple = true, dataTypeClass = Integer.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "getRulesByIds")
	public List<Rules> getRulesByIds(@RequestBody List<Integer> ids);

	@ApiOperation(value = "Get all the Rules", notes = "Returns Rules based on the page size", response = Rules.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Getting list of Rules"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "pageNo", allowMultiple = false, dataTypeClass = Integer.class, value = "Passed as Query param", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", allowMultiple = false, dataTypeClass = Integer.class, value = "Passed as Query param", paramType = "query", required = false),
			@ApiImplicitParam(name = "sortBy", allowMultiple = false, dataTypeClass = String.class, value = "Passed as Query param", paramType = "query", required = false) })
	@GetMapping(value = "getAllRules")
	public List<Rules> getAllRules(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "ruleId") String sortBy);
	
	
	@ApiOperation(value = "Check whether the rule exists or not", notes = "Returns true value if the rule exist and vice versa", response = Boolean.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "ruleWrapper", allowMultiple = false, dataTypeClass = RulesWrapper.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "isRuleExists")
	public Boolean isRuleExists(@RequestBody RulesWrapper ruleWrapper);
}
