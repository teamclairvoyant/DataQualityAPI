package com.cv.dataqualityapi.wrapper;

import java.util.List;

import com.cv.dataqualityapi.model.Rules;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
//@ToString
public class RuleSetRulesWrapper {

	private Integer rulesetId;

	private List<Rules> rules;

	@Override
	public String toString() {
		return "RuleSetRulesWrapper [rulesetId=" + rulesetId + ", rules=" + rules + "]";
	}
	

}
