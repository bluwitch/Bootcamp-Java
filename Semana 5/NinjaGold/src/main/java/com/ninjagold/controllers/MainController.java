package com.ninjagold.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String index() {
        return "index"; // No incluir "WEB-INF/" en el nombre de la vista
    }
}

