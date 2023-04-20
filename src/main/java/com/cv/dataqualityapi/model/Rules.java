package com.cv.dataqualityapi.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NamedQueries({
		@NamedQuery(name = "Rules.getAllRulesPks", query = "SELECT new com.cv.dataqualityapi.model.Rules(r.ruleId) from Rules r"),
		@NamedQuery(name = "Rules.getRuleCount", query = "SELECT count(r) from Rules r JOIN r.clients c JOIN r.rulesType rt where UPPER(rt.typeName) = UPPER(:typeName) and UPPER(r.ruleDesc) = UPPER(:ruleDesc) and UPPER(r.tableName) = UPPER(:tableName) and UPPER(r.columnName) = UPPER(columnName) and UPPER(r.columnValue) = UPPER(:columnValue) and UPPER(r.sourceName) = UPPER(sourceName) and UPPER(c.clientName) = UPPER(:clientName)"),
		@NamedQuery(name = "Rules.getRules", query = "SELECT r from Rules r JOIN r.clients c JOIN r.rulesType rt where UPPER(rt.typeName) = UPPER(:typeName) and UPPER(r.ruleDesc) = UPPER(:ruleDesc) and UPPER(r.tableName) = UPPER(:tableName) and UPPER(r.columnName) = UPPER(:columnName) and UPPER(r.columnValue) = UPPER(:columnValue) and UPPER(r.sourceName) = UPPER(:sourceName) and UPPER(c.clientName) = UPPER(:clientName)") })

@ApiModel	
@Getter
@Setter
@NoArgsConstructor
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

	// newly added
	@Column(name = "table_name", nullable = false, length = 50)
	@ApiModelProperty(notes = "Table Name", example = "Some table name", required = false) 
	private String tableName;

	@Column(name = "column_name", nullable = false, length = 50)
	@ApiModelProperty(notes = "Column Name", example = "Some column name", required = false) 
	private String columnName;

	// newly added
	@Column(name = "column_value", nullable = false, length = 50)
	@ApiModelProperty(notes = "Column Value", example = "Some column value", required = false) 
	private String columnValue;

	@Column(name = "source_name", nullable = false, length = 50)
	@ApiModelProperty(notes = "Source Name", example = "Some Source Name", required = false) 
	private String sourceName;

//	@Column(name = "attributes", nullable = false, length = 50)
//	private String attributes;

//	@ManyToMany(mappedBy = "rules")
//	private Set<RuleSet> ruleSet;

	@OneToOne
	@JoinColumn(name = "client_id", referencedColumnName = "client_id")
	private Clients clients;

	@JsonIgnore
	@OneToMany(mappedBy = "rules", cascade = CascadeType.ALL)
	private Set<RuleRuleSet> ruleRuleSet;

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

	public Rules(Integer ruleId, RulesType rulesType, String ruleDesc, String tableName, String columnName,
			String columnValue, String sourceName, Clients clients, Set<RuleRuleSet> ruleRuleSet, Date createdTs,
			Date updatedTs, String createdBy, String updatedBy) {
		super();
		this.ruleId = ruleId;
		this.rulesType = rulesType;
		this.ruleDesc = ruleDesc;
		this.tableName = tableName;
		this.columnName = columnName;
		this.columnValue = columnValue;
		this.sourceName = sourceName;
		this.clients = clients;
		this.ruleRuleSet = ruleRuleSet;
		this.createdTs = createdTs;
		this.updatedTs = updatedTs;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

}