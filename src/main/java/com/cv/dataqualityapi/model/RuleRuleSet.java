package com.cv.dataqualityapi.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NamedQueries({
	@NamedQuery(name = "RuleRuleSet.getRulesByRuleSetId", query = "SELECT r from RuleRuleSet r where r.ruleSet.rulesetId in (:rulesetId)")
	})

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "rule_ruleset")
public class RuleRuleSet {
	
	@ToString.Exclude
	@EmbeddedId
	private RuleRuleSetKey id;
	
    @ManyToOne
    @MapsId("ruleset_id")
    @JoinColumn(name = "ruleset_id")
    RuleSet ruleSet;

    @ManyToOne
    @MapsId("rule_id")
    @JoinColumn(name = "rule_id")
    Rules rules;

}
