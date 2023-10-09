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
public class EntityTemplatePropertiesDto {

    private String entityTemplatePropId;

    private String createdBy;

    private String createdDate;

    private String entityTemplatePropDesc;

    private String entityTemplatePropKey;

    private String entityTemplatePropType;

    private String isMandatory;

    private String updatedBy;

    private String updatedDate;
}
