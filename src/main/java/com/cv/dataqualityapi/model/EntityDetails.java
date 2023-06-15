package com.cv.dataqualityapi.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "entity_details")
public class EntityDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "EntityDetails Id", example = "1", required = true)
	@Column(name = "entityDetails_id")
	private Integer entityDetailsId;

	@ApiModelProperty(notes = "behaviour", example = "Source")
	@Column(name = "behaviour")
	private String behaviour;

	@ApiModelProperty(notes = "type of entity", example = "FILE")
	@Column(name = "type")
	private String type;

	@ApiModelProperty(notes = "sub type of entity", example = "CSV")
	@Column(name = "sub_type")
	private String subType;

	@ApiModelProperty(notes = "table name", example = "Transactions")
	@Column(name = "table_name")
	private String tableName;

	@ApiModelProperty(notes = "location of entity", example = "local")
	@Column(name = "location")
	private String location;

	@ApiModelProperty(notes = "description of entity", example = "transactions of credit cards")
	@Column(name = "description")
	private String description;

	@ApiModelProperty(notes = "primary key of table", example = "trans_id")
	@Column(name = "primary_key")
	private String primaryKey;

	@OneToMany(mappedBy = "entityTable", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("entityTable")
	private Set<Rules> rules;
}