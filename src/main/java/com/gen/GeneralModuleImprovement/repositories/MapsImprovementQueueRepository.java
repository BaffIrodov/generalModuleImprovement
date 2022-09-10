package com.gen.GeneralModuleImprovement.repositories;

import com.gen.GeneralModuleImprovement.entities.MapsImprovementQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapsImprovementQueueRepository extends JpaRepository<MapsImprovementQueue, Integer> {

}
