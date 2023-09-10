package com.cv.dataqualityapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTemplateDetailsDTO {

    private String id;

    private String name;

    private String description;

    private List<CreateTemplatePropertiesDTO> templateProperties;

}
