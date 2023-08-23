package com.bootcamp.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.languages.models.Language;
import com.bootcamp.languages.repositories.LanguageRepo;

@RestController
public class LangController {
	
	@Autowired
	private LanguageRepo repo;

	@GetMapping
	public List<Language> listaLenguajes(){
		return repo.findAll();
	}
	
	@PostMapping
	public void insertarLenguaje(Language lang){
		repo.save(lang);
	}
}
