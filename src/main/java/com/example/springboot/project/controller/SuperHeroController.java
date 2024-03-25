package com.example.springboot.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.springboot.project.entity.SuperHero;
import com.example.springboot.project.service.SuperHeroService;

@RestController
public class SuperHeroController {
	@Autowired
	SuperHeroService superHeroService;

	@GetMapping(path = "/insert-superhero-form")
	public ModelAndView getInsertSuperHeroForm() {
		System.out.println("GET: /insert-superhero-form");
		ModelAndView modeandView = new ModelAndView();
		String viewName = "insertSuperHeroForm";
		modeandView.setViewName(viewName);
		modeandView.addObject("greetMessage", "Welcome Deepak");
		System.out.println(modeandView);
		return modeandView;
	}
	
	@PostMapping(path = "/post-superhero")
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

}
