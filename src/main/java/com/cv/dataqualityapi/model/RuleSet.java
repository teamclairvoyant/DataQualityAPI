package com.cv.dataqualityapi.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NamedQueries({
		@NamedQuery(name = "RuleSet.getRuleSetByRuleSetName", query = "SELECT rs from RuleSet rs where upper(rs.rulesetName) = upper(:rulesetName)"),
		@NamedQuery(name = "RuleSet.getRuleSetCount", query = "SELECT rs from RuleSet rs where upper(rs.rulesetName) = upper(:rulesetName) and upper(rs.rulesetDesc) = upper(:rulesetDesc)") })

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ruleset")
public class RuleSet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ruleset_id")
	private Integer rulesetId;

	@Column(name = "ruleset_name", nullable = false, length = 100)
	private String rulesetName;

	@Column(name = "ruleset_desc", nullable = false, length = 200)
	private String rulesetDesc;

	@ManyToMany(mappedBy = "ruleSet")	
	@JsonBackReference
	private Set<Rules> rules;

//	present as fk in RulesetFrequency
	@OneToOne(mappedBy = "ruleSet")
	private RulesetFrequency rulesetFrequency;

	/*
	 * @OneToMany(mappedBy = "ruleSet", cascade = CascadeType.ALL) private
	 * Set<RuleRuleSet> ruleRuleSet;
	 */


}
