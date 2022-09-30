package com.gen.GeneralModuleImprovement.controllers;

import com.gen.GeneralModuleImprovement.services.DebugService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/debug")
@Log4j2
public class DebugController {
    @Autowired
    DebugService debugService;

    @GetMapping("/files-distribution")
    public void filesWithDistribution() {
        debugService.getFilesWithDistribution();
    }

    @GetMapping("/debug")
    public void debug() {
//        calculatingService.debug();
    }

    @GetMapping("/reset-players-forces")
    public void resetPlayersForces() {
        debugService.resetAllPlayerForcesToDefault();
    }

    @GetMapping("/enabled")
    public Boolean thisServiceEnabled() {
        return true;
    }
}
