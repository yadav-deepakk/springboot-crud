package com.example.springboot.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.project.entity.SuperHero;
import com.example.springboot.project.service.SuperHeroService;

@RestController
@RequestMapping("/superhero")
public class SuperHeroController {

	@Autowired
	SuperHeroService superHeroService;

	@GetMapping
	public ResponseEntity<List<SuperHero>> getAllSuperHero() {
		System.out.println("GET: /superhero(s)");
		try {
			List<SuperHero> superHeros = superHeroService.getAllSuperHero();
			System.out.println(superHeros);
			return new ResponseEntity<>(superHeros, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{superHeroId}")
	public ResponseEntity<SuperHero> getSuperHeroById(@PathVariable Long superHeroId) {
		System.out.println("GET: /superhero/id");
		System.out.println(superHeroId);
		try {
			SuperHero superHero = superHeroService.getSuperHeroById(superHeroId);
			System.out.println(superHero);
			return new ResponseEntity<SuperHero>(superHero, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<String> insertSuperHero(@RequestBody SuperHero superHero) {
		System.out.println("POST: /superhero");
		System.out.println(superHero);
		try {
			superHeroService.saveSuperHero(superHero);
			return new ResponseEntity<>("{message: 'inserted', status: 200}", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("{message: 'internal server error', status: 500}",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateinfo")
	public ResponseEntity<String> updateSuperHeroName(@RequestBody SuperHero superHero) {
		System.out.println("PUT: superhero/updateInfo/");
		System.out.println(superHero);
		try {
			superHeroService.updateSuperHeroDetails(superHero);
			return new ResponseEntity<>("{message: 'update successful', status: 200}", HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>("{message: 'update un-successful', status: 500}",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateinfo/{superHeroId}/name")
	public ResponseEntity<String> updateSuperHeroName(@PathVariable(name = "superHeroId") Long superHeroId,
			@RequestParam(name = "superHeroName", required = true) String superHeroName) {
		System.out.println("PUT: superhero/updateInfo?id=" + superHeroId + "&superHeroName=" + superHeroName);
		try {
			superHeroService.updateSuperHeroName(superHeroId, superHeroName);
			return new ResponseEntity<>("{message: 'update successful', status: 200}", HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>("{message: 'update un-successful', status: 500}",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateinfo/{superHeroId}/humanName")
	public ResponseEntity<String> updateSuperHeroHumanName(@PathVariable(name = "superHeroId") Long superHeroId,
			@RequestParam(name = "superHeroHumanName", required = true) String superHeroHumanName) {
		System.out.println("PUT: superhero/updateInfo?id=" + superHeroId + "&superHeroHumanName=" + superHeroHumanName);
		try {
			superHeroService.updateSuperHeroHumanName(superHeroId, superHeroHumanName);
			return new ResponseEntity<>("{message: 'update successful', status: 200}", HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>("{message: 'update un-successful', status: 500}",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateinfo/{superHeroId}/power")
	public ResponseEntity<String> updateSuperHero(@PathVariable(name = "superHeroId") Long superHeroId,
			@RequestParam(name = "power", required = true) int power) {
		System.out.println("PUT: superhero/updateInfo?id=" + superHeroId + "&power=" + power);
		try {
			superHeroService.updateSuperHeroPower(superHeroId, power);
			return new ResponseEntity<>("{message: 'update successful', status: 200}", HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>("{message: 'update un-successful', status: 500}",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{superHeroId}")
	public ResponseEntity<String> deleteSuperHeroById(@PathVariable Long superHeroId) {
		System.out.println("DELETE: /delete/{superHeroId}" + superHeroId);
		try {
			superHeroService.deleteSuperHeroById(superHeroId);
			return new ResponseEntity<>("{message: 'delete successful', status: 200}", HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>("{message: 'delete un-successful', status: 500}",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
