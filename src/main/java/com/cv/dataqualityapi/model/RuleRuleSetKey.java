package com.cv.dataqualityapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Embeddable
public class RuleRuleSetKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2019106377187888184L;

	@Column(name = "ruleset_id")
	Integer rulesetId;

	@Column(name = "rule_id")
	Integer ruleId;

}