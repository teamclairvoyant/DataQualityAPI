package com.cv.dataqualityapi.wrapper;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RuleRuleSetWrapper {

	Integer rulesetId;
	List<Integer> ruleIds;
}
