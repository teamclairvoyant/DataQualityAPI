package com.cv.dataqualityapi.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EntityPropertiesDto {

    private String entityPropId;

    private String createdBy;

    private String createdDate;

    private String entityPropKey;

    private String entityPropValue;

    private String updatedBy;

    private String updatedDated;
}
