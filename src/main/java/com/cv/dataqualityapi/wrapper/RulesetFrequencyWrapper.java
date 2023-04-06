package com.cv.dataqualityapi.wrapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RulesetFrequencyWrapper {
	
	private Integer freqId;

	private Integer ruleSetId;
	
	private String ruleSetName;

	private String frequency;
}
