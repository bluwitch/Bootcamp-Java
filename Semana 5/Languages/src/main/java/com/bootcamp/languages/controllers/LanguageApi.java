package com.bootcamp.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.languages.models.Language;
import com.bootcamp.languages.repositories.LanguageRepo;
import com.bootcamp.languages.services.LanguageService;

@RestController
public class LanguageApi {
	@Autowired
	private LanguageService languageService;

	@Autowired
	private LanguageRepo languageRepo;

// Busca Todos los lenguajes
	@GetMapping("/languages")
	public List<Language> listar() {
		return languageRepo.findAll();
	}

// Busca un lenguaje
	@GetMapping("/languages/{id}")
	public Language buscar(@PathVariable("id") Long id) {
		return languageService.findLanguage(id);
	}

// Crea un lenguaje
	@PostMapping("/languages")
	public void insertar(@RequestBody Language language) {
		languageRepo.save(language);
	}

// Edita un lenguaje
	@PutMapping("/languages/{id}")
	public void editar(@PathVariable("id") Long id, @RequestBody Language language) {
	    // Asigna el ID al objeto language
	    language.setId(id);
	    languageService.updateLanguage(language);
	}

// Borra un lenguaje
	@DeleteMapping(value = "/languages/{id}")
	public void delete(@PathVariable("id") Long id) {
		languageRepo.deleteById(id);
	}

}