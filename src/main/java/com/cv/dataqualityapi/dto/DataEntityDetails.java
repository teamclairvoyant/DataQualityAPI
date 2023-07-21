package com.cv.dataqualityapi.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DataEntityDetails {
	private Integer id;
	private String type;
	private String subType;
	private String physicalName;
	private String location;
	private String description;
	private String primaryKey;
}
