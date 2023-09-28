package com.cv.dataqualityapi.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class JsonResponseDto {

  private Integer id;

  private String name;

  private String description;

  private List<String> notificationPreferences;

  private List<RulesJsonDto> rules;
}