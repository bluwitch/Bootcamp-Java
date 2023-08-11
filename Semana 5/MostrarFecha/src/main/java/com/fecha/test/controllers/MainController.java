package com.fecha.test.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/date")
	public String fecha(Model modelo) {
		SimpleDateFormat fecha = new SimpleDateFormat("EEEE, MMM d, YYY");
		Date date = new Date();
		
		modelo.addAttribute("fecha", fecha.format(date));
		return "date";
	}
	
	@GetMapping("/time")
		public String hora(Model modelo2) {
			SimpleDateFormat fecha = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			
			modelo2.addAttribute("fecha", fecha.format(date));
			return "date";
	}
		
}
