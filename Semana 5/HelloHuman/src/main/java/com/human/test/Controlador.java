package com.human.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
	@RequestMapping("/")
	public String a(@RequestParam(value="nombre", defaultValue="Martu", required=false) String nombre ) {
		return "Hola " + nombre;
	}
}