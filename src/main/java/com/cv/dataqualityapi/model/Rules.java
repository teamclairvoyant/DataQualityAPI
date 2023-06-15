package com.cv.dataqualityapi.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cv.dataqualityapi.converter.PropertiesConverter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NamedQueries({
		@NamedQuery(name = "Rules.getAllRulesPks", query = "SELECT new com.cv.dataqualityapi.model.Rules(r.ruleId) from Rules r"),
		// @NamedQuery(name = "Rules.getRuleCount", query = "SELECT count(r) from Rules
		// r JOIN r.clients c JOIN r.rulesType rt where UPPER(rt.typeName) =
		// UPPER(:typeName) and UPPER(r.ruleDesc) = UPPER(:ruleDesc) and
		// UPPER(r.tableName) = UPPER(:tableName) and UPPER(r.columnName) =
		// UPPER(columnName) and UPPER(r.columnValue) = UPPER(:columnValue) and
		// UPPER(r.sourceName) = UPPER(sourceName) and UPPER(c.clientName) =
		// UPPER(:clientName)"),
		@NamedQuery(name = "Rules.getRules", query = "SELECT r from Rules r JOIN r.rulesType rt JOIN r.ruleSet rs JOIN r.entityTable et where UPPER(rt.typeName) = UPPER(:typeName) or UPPER(r.ruleDesc) = UPPER(:ruleDesc) or UPPER(r.ruleName) = UPPER(:ruleName) or  UPPER(rs.rulesetName) = UPPER(:ruleSet) or UPPER(et.tableName) = UPPER(:entityTable)") })

@ApiModel
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "rules")
public class Rules {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Rule ID", example = "1", required = true)
	@Column(name = "rule_id")
	private Integer ruleId;

	@OneToOne
	@JoinColumn(name = "ruletype_id", referencedColumnName = "ruletype_id")
	private RulesType rulesType;

	// newly added
	@Column(name = "rule_desc", nullable = false, length = 100)
	@ApiModelProperty(notes = "Rule Description", example = "Some description of the Rule", required = false)
	private String ruleDesc;

	@Column(name = "rule_name", nullable = false)
	@ApiModelProperty(notes = "Rule Name", example = "Some Name for Rule", required = false)
	private String ruleName;

	// newly added
	@ApiModelProperty(notes = "Table Name", example = "Some table name", required = false)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "entity_details_id")
	@JsonIgnoreProperties("rules")
	private EntityDetails entityTable;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "rules_ruleset", joinColumns = @JoinColumn(name = "ruleId"), inverseJoinColumns = @JoinColumn(name = "ruleset_id"))
	@JsonManagedReference
	private Set<RuleSet> ruleSet = new HashSet<>();

	@Column(name = "properties", nullable = false)
	@ApiModelProperty(notes = "Properties", example = "Properties", required = false)
	@Convert(converter = PropertiesConverter.class)
	private Properties properties;

	@Column(name = "created_ts")
	@ApiModelProperty(notes = "Rule creation timestamp", example = "2023-04-18 14:20:20.785", required = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTs;

	@Column(name = "updated_ts")
	@ApiModelProperty(notes = "Rule updation timestamp", example = "2023-04-18 14:20:20.785", required = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTs;

	@Column(name = "created_by", length = 100)
	@ApiModelProperty(notes = "Created by name", example = "Clairvoyant", required = false)
	private String createdBy;

	@Column(name = "updated_by", length = 100)
	@ApiModelProperty(notes = "Updated by name", example = "EXL", required = false)
	private String updatedBy;

	public Rules(Integer ruleId) {
		super();
		this.ruleId = ruleId;
	}
}