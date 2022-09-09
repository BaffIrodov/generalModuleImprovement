package com.gen.GeneralModuleImprovement.repositories;

import com.gen.GeneralModuleImprovement.entities.Errors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorsRepository extends JpaRepository<Errors, Integer> {

}
