package com.gen.GeneralModuleImprovement.calculatingMethods;

import com.gen.GeneralModuleImprovement.entities.PlayerForce;
import com.gen.GeneralModuleImprovement.entities.PlayerOnMapResults;
import com.gen.GeneralModuleImprovement.repositories.PlayerForceRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ForceTeamCalculator {

    @Autowired
    JPAQueryFactory queryFactory;
    @Autowired
    PlayerForceRepository playerForceRepository;

    // эту силу прибавляем к силе игрока. Если он выиграл сильных - тогда ему начисляется больший счет, иначе - меньший
    public float getForceTeam(List<PlayerOnMapResults> team, Map<Integer, List<PlayerForce>> playerForcesMap) {
        List<Integer> ids = team.stream().map(e -> e.playerId).toList();
        List<PlayerForce> playerForces = new ArrayList<>();
        ids.forEach(id -> {
            playerForces.add(playerForcesMap.get(id).get(0));
        });
        float result = (float) playerForces.stream().map(e -> e.playerForce).mapToDouble(i -> i).sum();
        if(result < 0) result = 0f; //побеждены слишком плохие игроки - никакой прибавки
        return result;
    }
}
