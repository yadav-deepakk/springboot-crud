package com.example.springboot.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.project.entity.SuperHero;

@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, Long>{
	
}
