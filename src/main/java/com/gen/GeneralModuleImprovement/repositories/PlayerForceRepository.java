package com.gen.GeneralModuleImprovement.repositories;

import com.gen.GeneralModuleImprovement.entities.PlayerForce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerForceRepository extends JpaRepository<PlayerForce, Integer> {

}
