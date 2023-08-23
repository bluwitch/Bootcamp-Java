package com.bootcamp.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bootcamp.languages.models.Language;
import com.bootcamp.languages.repositories.LanguageRepo;

@Controller
public class LangController {

	@Autowired
	private LanguageRepo repo;

	@GetMapping("/languages")
	public String showLanguages(Model model) {
		// Obtener la lista de lenguajes desde el repositorio
		List<Language> languages = repo.findAll();

		// Agregar la lista de lenguajes al modelo
		model.addAttribute("languages", languages);

		// Devolver el nombre de la vista HTML
		return "languages";
	}
	
	

//	@PostMapping
//	public void insertarLenguaje(Language lang) {
//		repo.save(lang);
//	}
}
