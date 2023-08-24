package com.bootcamp.languages.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.languages.models.Language;
import com.bootcamp.languages.repositories.LanguageRepo;

import jakarta.transaction.Transactional;

@Service
public class LanguageService {
	private final LanguageRepo languageRepo;

	public LanguageService(LanguageRepo languageRepo) {
		this.languageRepo = languageRepo;
	}

	// Devuelve todos los lenguajes
	public List<Language> allLanguages() {
		return languageRepo.findAll();
	}

	// Crea un lenguaje
	public Language createLanguage(Language lang) {
		return languageRepo.save(lang);
	}

	// Obtiene la información de un lenguaje
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}

	// Edita un lenguaje
	@Transactional
	public void updateLanguage(Language language) {
		// Verificar si el lenguaje ya existe en la base de datos
		Language existingLanguage = languageRepo.findById(language.getId()).orElse(null);
		if (existingLanguage != null) {
			// Actualiza los campos necesarios del lenguaje existente
			existingLanguage.setName(language.getName());
			existingLanguage.setCreator(language.getCreator());
			existingLanguage.setCurrentVersion(language.getCurrentVersion());
			// Guardar los cambios en la base de datos
			languageRepo.save(existingLanguage);
		}
	}
	
	
    //Eliminar lenguaje
    public void deleteLanguage(Long id){
        if(languageRepo.existsById(id)){
            languageRepo.deleteById(id);
        }else{
            throw new NoSuchElementException("No se encontro el lenguaje a eliminar");
        }
    }
}
