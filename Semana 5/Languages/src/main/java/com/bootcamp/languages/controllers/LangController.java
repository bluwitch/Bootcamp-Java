package com.bootcamp.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bootcamp.languages.models.Language;
import com.bootcamp.languages.repositories.LanguageRepo;
import com.bootcamp.languages.services.LanguageService;

import jakarta.validation.Valid;

@Controller
public class LangController {
	private final LanguageService languageService;

	public LangController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@Autowired
	private LanguageRepo repo;

	// Muestra el dashboard con los lenguajes
	@GetMapping("/languages")
	public String mostrarLanguages(Model model) {
		// Obtener la lista de lenguajes desde el repositorio
		List<Language> languages = repo.findAll();

		// Agregar la lista de lenguajes al modelo
		model.addAttribute("languages", languages);

		// Devolver el nombre de la vista HTML
		return "languages";
	}

	// Devuelve la vista de un lenguaje específico
	@GetMapping("/languages/{id}")
	public String buscar(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "vista"; //
	}

	// crea un lenguaje en el formulario
	@PostMapping("/languages")
	public String insertarLenguaje(@ModelAttribute @Valid Language language, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "languages";
		}
		repo.save(language);
		return "redirect:/languages"; // Redirige de nuevo a la página "languages"
	}

	// Muestra el lenguaje a editar
	@GetMapping("/languages/edit/{id}")
	public String vistaEdit(@PathVariable("id") Long id, Model model) {
		Language language = repo.findById(id).orElse(null);
		model.addAttribute("language", language);
		return "edit";
	}

	// Edita el lenguaje
	@PostMapping("/languages/edit/{id}")
	public String updateLanguage(@PathVariable("id") Long id, @ModelAttribute Language updatedLanguage) {
		// Obtener el lenguaje por ID desde el repositorio
		Language existingLanguage = repo.findById(id).orElse(null);

		if (existingLanguage != null) {
			// Actualizar los campos del lenguaje existente
			existingLanguage.setName(updatedLanguage.getName());
			existingLanguage.setCreator(updatedLanguage.getCreator());
			existingLanguage.setCurrentVersion(updatedLanguage.getCurrentVersion());

			// Guardar los cambios en el repositorio
			repo.save(existingLanguage);
		}

		// Redirigir a la página de listado de lenguajes
		return "redirect:/languages";
	}

	// Elimina un lenguaje en la tabla
	@RequestMapping(value = "/languages/delete/{id}", method = RequestMethod.POST)
	public String deleteLanguage(@PathVariable Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages"; // Redireccionar a la lista de lenguajes después del borrado
	}

}
