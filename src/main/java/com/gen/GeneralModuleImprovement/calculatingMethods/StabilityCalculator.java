package com.gen.GeneralModuleImprovement.calculatingMethods;

import com.gen.GeneralModuleImprovement.entities.PlayerForce;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StabilityCalculator {

    // размышления на 030922
    // стабильность будет учитываться здесь - при пересчете стабильности
    // а также при предиктах. При расчетах сил не имеет смысла угнетать игроков стабильностью
    // иначе может возникнуть ситуация, когда проигравшая команда с 100% стабильностью получит
    // очков больше, чем выигравшая команда с 90% стабильностью. Также игроки, которые потеряли
    // стабильность, начнут на дистанции угнетаться, и через год получат сильно меньше очков,
    // чем могли бы
    public void calculateCorrectedStability(List<PlayerForce> leftTeam,
                                                         List<PlayerForce> rightTeam,
                                                         String teamWinner) {
        float leftTeamStability = (float) leftTeam.stream().mapToDouble(e -> e.playerStability).average().getAsDouble();
        float rightTeamStability = (float) rightTeam.stream().mapToDouble(e -> e.playerStability).average().getAsDouble();
        float leftTeamForce = (float) leftTeam.stream().mapToDouble(e -> e.playerForce).sum()
                * (float) leftTeamStability/100;
        float rightTeamForce = (float) rightTeam.stream().mapToDouble(e -> e.playerForce).sum()
                * (float) rightTeamStability/100;
        // левые существенно сильнее правых по расчетам, но проиграли на практике
        if ((leftTeamForce / rightTeamForce) > Config.stabilityCompareCoeff
                && teamWinner.equals("right")) {
            //вся команда левых снижает свою стабильность
            leftTeam.forEach(l -> l.playerStability -= 1f);
            //TODO в случае, когда мы отрицательным присваиваем меньшую стабильность - произойдет искажение
            //TODO надо поставить нижнюю границу 0
        }
        // правые существенно сильнее левых по расчетам, но проиграли на практике
        if ((rightTeamForce / leftTeamForce) > Config.stabilityCompareCoeff
            && teamWinner.equals("left")) {
            //вся команда правых снижает свою стабильность
            rightTeam.forEach(r -> r.playerStability -= 1f);
        }
//        return isLeftReturn ? leftTeam : rightTeam;
    }

}
