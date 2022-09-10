package com.gen.GeneralModuleImprovement.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class ImprovementRequestDto {
    private Integer testDatasetPercent;
    private Map<String, Object> config;
}
