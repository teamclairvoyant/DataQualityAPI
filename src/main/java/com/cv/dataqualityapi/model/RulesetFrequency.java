package com.cv.dataqualityapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ruleset_frequency")
public class RulesetFrequency {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "freq_id")
	private Integer freqId;

	@OneToOne
	@JoinColumn(name = "ruleset_id", referencedColumnName = "ruleset_id")
	private RuleSet ruleSet;

	@Column(name = "frequency", nullable = false, length = 50)
	private String frequency;

	public RulesetFrequency(Integer freqId, RuleSet ruleSet, String frequency) {
		super();
		this.freqId = freqId;
		this.ruleSet = ruleSet;
		this.frequency = frequency;
	}

}
