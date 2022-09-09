package com.gen.GeneralModuleImprovement;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@SpringBootApplication
@EntityScan({"com.gen.GeneralModuleImprovement.entities", "com.querydsl.jpa.impl"})
public class GeneralModuleImprovementApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneralModuleImprovementApplication.class, args);

	}

	@Bean
	public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
		return new JPAQueryFactory(entityManager);
	}

}
