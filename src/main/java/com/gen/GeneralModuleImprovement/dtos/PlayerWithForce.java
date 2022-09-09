package com.gen.GeneralModuleImprovement.dtos;

import com.gen.GeneralModuleImprovement.entities.PlayerForce;
import com.gen.GeneralModuleImprovement.entities.PlayerOnMapResults;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayerWithForce {
    public PlayerOnMapResults playerOnMapResults;
    public PlayerForce playerForce;
}
