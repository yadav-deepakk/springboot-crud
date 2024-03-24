package com.example.springboot.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.project.entity.SuperHero;
import com.example.springboot.project.repository.SuperHeroRepository;

@Service
public class SuperHeroService {
	@Autowired
	SuperHeroRepository superHeroRepo;

	public List<SuperHero> getAllSuperHero() throws Exception {
		return superHeroRepo.findAll();
	}

	public SuperHero getSuperHeroById(Long superHeroId) throws Exception {
		return superHeroRepo.findById(superHeroId).get();
	}

	public void saveSuperHero(SuperHero hero) throws Exception {
		superHeroRepo.save(hero);
	}

	public void updateSuperHeroDetails(SuperHero superHero) throws Exception {
		if (superHero != null) {
			superHeroRepo.save(superHero);
		} else {
			throw new Exception("can not save details.");
		}
	}

	public void updateSuperHeroName(Long superHeroId, String heroName) throws Exception {
		SuperHero superHero = superHeroRepo.findById(superHeroId).get();
		if (superHero != null) {
			superHero.setName(heroName);
			superHeroRepo.save(superHero);
		} else {
			throw new Exception("super hero is not present, so can not update name.");
		}
	}

	public void updateSuperHeroHumanName(Long superHeroId, String heroHumanName) throws Exception {
		SuperHero superHero = superHeroRepo.findById(superHeroId).get();
		if (superHero != null) {
			superHero.setHumanName(heroHumanName);
			superHeroRepo.save(superHero);
		} else {
			throw new Exception("super hero is not present, so can not update human-name.");
		}
	}

	public void updateSuperHeroPower(Long superHeroId, int heroPower) throws Exception {
		SuperHero superHero = superHeroRepo.findById(superHeroId).get();
		if (superHero != null) {
			superHero.setPower(heroPower);
			superHeroRepo.save(superHero);
		} else {
			throw new Exception("super hero is not present, so can not update power.");
		}
	}

	public void deleteSuperHeroById(Long superHeroId) throws Exception {
		superHeroRepo.deleteById(superHeroId);
	}

}
