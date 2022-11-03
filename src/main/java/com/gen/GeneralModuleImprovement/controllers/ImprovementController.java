package com.gen.GeneralModuleImprovement.controllers;

import com.gen.GeneralModuleImprovement.dtos.ImprovementRequestDto;
import com.gen.GeneralModuleImprovement.dtos.MapsCalculatingQueueResponseDto;
import com.gen.GeneralModuleImprovement.dtos.PatternTemplateNumber;
import com.gen.GeneralModuleImprovement.services.ImprovementService;
import com.gen.GeneralModuleImprovement.services.DebugService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/improvement")
@Log4j2
public class ImprovementController {

    @Autowired
    ImprovementService improvementService;

    @Autowired
    DebugService debugService;

    @GetMapping("/get-config")
    public Map<String, Object> getConfig() {
        return improvementService.getConfig();
    }

    @PostMapping("/inactive-percent")
    public void improvementInactivePercent(@RequestBody ImprovementRequestDto request) {
        improvementService.inactivePercent(request);
    }

    @PostMapping("/no-config")
    public void improvementNoConfig(@RequestBody ImprovementRequestDto request) {
        improvementService.noConfig(request);
    }

    @PostMapping("/with-config")
    public void improvementWithConfig(@RequestBody ImprovementRequestDto request) {
        //TODO напрямую map не посылается - хз, почему
        request.config = new HashMap<>();
        request.configList.forEach(e -> {
            request.config.put(e.name, e.value);
        });
        improvementService.withConfig(request);
    }

    @PostMapping("/with-config-and-pattern")
    public void improvementWithConfigAndPattern(@RequestBody PatternTemplateNumber patternTemplateNumber) {
        //TODO напрямую map не посылается - хз, почему
        patternTemplateNumber.improvementRequest.config = new HashMap<>();
        patternTemplateNumber.improvementRequest.configList.forEach(e -> {
            patternTemplateNumber.improvementRequest.config.put(e.name, e.value);
        });
        improvementService.withConfigAndPattern(patternTemplateNumber);
    }

}
