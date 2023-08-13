package com.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	private static final Map<String, PlaceInfo> lugares = new HashMap<>();
	static {
		lugares.put("farm", new PlaceInfo(10, 20, "(earns 10-20 gold)", "Farm"));
		lugares.put("cave", new PlaceInfo(5, 10, "(earns 5-10 gold)", "Cave"));
		lugares.put("house", new PlaceInfo(2, 5, "(earns 2-5 gold)", "House"));
		lugares.put("casino", new PlaceInfo(-50, 50, "(earns/takes 50 gold)", "Casino"));
		// Agrega otros lugares aquí si es necesario
	}

	// redirecciona a la ruta /gold
	@GetMapping("/")
	public String irGold() {
		return "redirect:/gold";
	}

	@GetMapping("/gold")
	public String index(HttpSession sesion, Model model) {
	    model.addAttribute("gold", sesion.getAttribute("gold"));

		return "index";
	}

	// puse un hashmap para no tener que usar tantos ifs

	@SuppressWarnings("unchecked")
	@PostMapping("/gold")
	public String enviarOro(HttpSession sesion, @RequestParam(value = "lugar") String lugar) {
	    int oro = 0;
	    ArrayList<String> ganancias = new ArrayList<>();
	    SimpleDateFormat formatFecha = new SimpleDateFormat("MMM DY h:mm a");

	    if (sesion.getAttribute("gold") == null) {
	        sesion.setAttribute("gold", oro);
	        sesion.setAttribute("ganancias", ganancias);
	    } else {
	        oro = (int) sesion.getAttribute("gold");
	        if (sesion.getAttribute("ganancias") != null) {
	            ganancias = (ArrayList<String>) sesion.getAttribute("ganancias");
	        }
	    }

		PlaceInfo placeInfo = lugares.get(lugar);
		if (placeInfo != null) {
		    int cantidad = new Random().nextInt(placeInfo.max - placeInfo.min + 1) + placeInfo.min;
		    String mensaje = "Entraste a " + placeInfo.nombre;
		    if (cantidad > 0) {
		        mensaje += " y aumentas " + cantidad + " oro";
		    } else if (cantidad < 0) {
		        mensaje += " y pierdes " + Math.abs(cantidad) + " oro";
		    }
		    mensaje += " (" + formatFecha.format(new Date()) + ")";
		    
		    ganancias.add(0, mensaje);
		    oro += cantidad;
		    sesion.setAttribute("gold", oro);
		    sesion.setAttribute("ganancias", ganancias);
		}

		return "redirect:/gold";

	}

	private static class PlaceInfo {
		private final int min;
		private final int max;
		private final String nombre;

		public PlaceInfo(int min, int max, String descripcion, String nombre) {
			this.min = min;
			this.max = max;
			this.nombre = nombre;
		}
	}
}
