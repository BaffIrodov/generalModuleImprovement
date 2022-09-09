package com.gen.GeneralModuleImprovement.repositories;

import com.gen.GeneralModuleImprovement.entities.MapsCalculatingQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapsCalculatingQueueRepository extends JpaRepository<MapsCalculatingQueue, Integer> {

}
