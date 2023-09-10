package com.cv.dataqualityapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTemplatePropertiesDTO {

    private String mandatory;

    private String description;

    private String type;

    private String key;

    private String value;
}