package com.gen.GeneralModuleImprovement.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
public class RoundHistory {
    @Id
    @SequenceGenerator(name = "sq_round_history", sequenceName = "sq_round_history_id", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_round_history")
    public int id; //id записи

    public Integer idStatsMap; //id stats-страницы
    public Date dateOfMatch; //дата матча
    public String roundSequence; //последовательность раундов - (L, L, L, R, R) - первая тима выигрывает 3, вторая выигрывает 2 раунда
    public Boolean leftTeamIsTerroristsInFirstHalf; //левая команда - терры в первой половине

//    public RoundHistory(){
//        this.idStatsMap = "";
//        this.dateOfMatch = null;
//        this.roundSequence = new ArrayList<>();
//    }
//
//    public boolean validateThisObject(){
//        return !this.idStatsMap.equals("") &&
//                this.dateOfMatch != null &&
//                this.roundSequence.size() > 0;
//    }
//
//    public RoundHistory returnValidatedObjectOrNull(){
//        if(validateThisObject()){
//            return this;
//        } else {
//            return null;
//        }
//    }
}
