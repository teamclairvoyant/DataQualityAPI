package com.cv.dataqualityapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RuleTemplatePropertiesDTO {

    private String mandatory;

    private String description;

    private String type;

    private String key;

    private String value;

}
