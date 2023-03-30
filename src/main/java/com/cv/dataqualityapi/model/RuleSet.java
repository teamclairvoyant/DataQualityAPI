package com.cv.dataqualityapi.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "ruleset")
public class RuleSet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ruleset_id")
	private Integer rulesetId;

	@Column(name = "ruleset_name", nullable = false, length = 100)
	private String rulesetName;

	@Column(name = "ruleset_desc", nullable = false, length = 200)
	private String rulesetDesc;

	@ManyToMany
	@JoinTable(name = "rule_rule_set_mapping", joinColumns = @JoinColumn(name = "ruleset_id"), inverseJoinColumns = @JoinColumn(name = "rule_id"))
	private Set<Rules> rules;

//	present as fk in RulesetFrequency
	@OneToOne(mappedBy = "ruleSet")
	private RulesetFrequency rulesetFrequency;

	public RuleSet(Integer rulesetId, String rulesetName, String rulesetDesc, Set<Rules> rules,
			RulesetFrequency rulesetFrequency) {
		super();
		this.rulesetId = rulesetId;
		this.rulesetName = rulesetName;
		this.rulesetDesc = rulesetDesc;
		this.rules = rules;
		this.rulesetFrequency = rulesetFrequency;
	}

}
