package com.cv.dataqualityapi.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.wrapper.RuleRuleSetWrapper;
import com.cv.dataqualityapi.wrapper.RuleSetRulesWrapper;
import com.cv.dataqualityapi.wrapper.RuleSetWrapper;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("RuleSet")
public interface RuleSetRest {

	@ApiOperation(value = "Create Rule Set", notes = "Returns saved message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "ruleSetWrapper", dataTypeClass = RuleSetWrapper.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "createRuleSet")
	public String createRuleSet(@RequestBody List<RuleSetWrapper> ruleSetWrapper) throws Exception;

	@ApiOperation(value = "Delete Rule Set", notes = "Returns saved message after successfull insertion", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "ruleSetId", dataTypeClass = Integer.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "deleteRuleSet")
	public String deleteRuleSet(@RequestBody List<Integer> ruleSetId) throws Exception;

	@ApiOperation(value = "Tag Rules to RuleSet", notes = "Returns saved message after successfull tagging", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "ruleRuleSetWrapper", dataTypeClass = RuleRuleSetWrapper.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "tagRulesToRuleSet")
	public String tagRulesToRuleSet(@RequestBody List<RuleRuleSetWrapper> ruleRuleSetWrapper) throws Exception;

	@ApiOperation(value = "Untag Rules to RuleSet", notes = "Returns saved message after successfull tagging", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "ruleRuleSetWrapper", dataTypeClass = RuleRuleSetWrapper.class, value = "The body is a json", paramType = "body", required = true) })
	@PostMapping(value = "untagRulesToRuleSet")
	public String untagRulesToRuleSet(@RequestBody List<RuleRuleSetWrapper> ruleRuleSetWrapper) throws Exception;

	@ApiOperation(value = "Get all the Rules associated with a Ruleset Id", notes = "Returns all the rules associated to the Ruleset", response = Rules.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Getting list of Rules"),
			@ApiResponse(code = 404, message = "Not found - The url was not found") })
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "rulesetId", allowMultiple = true, dataTypeClass = RuleSetRulesWrapper.class, value = "Integer value", paramType = "body", required = true) })
	@PostMapping(value = "getRulesByRuleSetIds")
	public List<RuleSetRulesWrapper> getRulesByRuleSetIds(@RequestBody List<Integer> rulesetId) throws Exception;

}
