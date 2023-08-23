package com.bootcamp.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.languages.models.Language;
import com.bootcamp.languages.repositories.LanguageRepo;

import jakarta.validation.Valid;

@Service
public class LanguageService {
	private final LanguageRepo languageRepo;

	public LanguageService(LanguageRepo languageRepo) {
	        this.languageRepo = languageRepo;
	    }

	// Devolviendo todos los libros.
	public List<Language> allLanguages() {
		return languageRepo.findAll();
	}

	// Creando un libro.
	public Language createBook(Language b) {
		return languageRepo.save(b);
	}

	// Obteniendo la información de un libro
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}

	public void updateLanguage(@Valid Language language) {
		// TODO Auto-generated method stub
		
	}
}
