package com.gen.GeneralModuleImprovement.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class ImprovementRequestDto {
    public Integer testDatasetPercent;
    public Map<String, Object> config;
    public List<ConfigAsList> configList;
}
