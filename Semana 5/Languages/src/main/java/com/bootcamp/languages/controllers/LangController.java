package com.bootcamp.languages.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bootcamp.languages.models.Language;
import com.bootcamp.languages.services.LanguageService;

import jakarta.validation.Valid;

@Controller
public class LangController {
    
    @Autowired
    private LanguageService languageService; // Asegúrate de inyectar el servicio

    @RequestMapping("/")
    public String redirectToLanguages() {
        return "redirect:/languages";
    }
    
    @RequestMapping("/languages")
    public String showLanguages() {
        return "languages";
    }
    
    @RequestMapping("/languages/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id); // Usar el servicio para buscar el lenguaje
        model.addAttribute("language", language);
        return "languages/edit";
    }
    
    @RequestMapping(value = "/languages/edit/{id}", method = RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "languages/edit";
        } else {
            languageService.updateLanguage(language); // Usar el servicio para actualizar el lenguaje
            return "redirect:/languages";
        }
    }
}