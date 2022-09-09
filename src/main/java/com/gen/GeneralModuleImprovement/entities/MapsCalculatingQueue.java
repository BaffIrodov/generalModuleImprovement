package com.gen.GeneralModuleImprovement.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class MapsCalculatingQueue {
    @Id
    public int idStatsMap;
    public int calculationTime;
    public boolean processed;
}
