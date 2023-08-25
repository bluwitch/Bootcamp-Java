package com.bootcamp.lookify.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.bootcamp.lookify.models.Song;
import com.bootcamp.lookify.repos.SongRepo;
import com.bootcamp.lookify.services.SongService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	private final SongService songService;

	public MainController(SongService songService) {
		this.songService = songService;
	}

	@Autowired
	private SongRepo repo;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	// Muestra el dashboard con las canciones
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = repo.findAll();

		model.addAttribute("songs", songs);

		return "dashboard";
	}

	// crea una canción en el formulario
	@PostMapping("/dashboard")
	public String addSong(@ModelAttribute @Valid Song song, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "new";
		}
		repo.save(song);
		return "redirect:/dashboard";
	}

	// Elimina una canción en la tabla
	@RequestMapping(value = "/dashboard/delete/{id}", method = RequestMethod.POST)
	public String deleteSong(@PathVariable Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard"; // Redireccionar a la lista de lenguajes después del borrado
	}

	@GetMapping("/songs/edit/{id}")
	public String vistaEdit(@PathVariable("id") Long id, Model model) {
		Song song = repo.findById(id).orElse(null);
		model.addAttribute("song", song);
		return "edit";
	}

	// Editar canción
	@PostMapping("/songs/edit/{id}")
	public String updateSong(@PathVariable("id") Long id, @ModelAttribute Song updatedSong) {
		// Obtener cancion por ID desde el repositorio
		Song existingSong = repo.findById(id).orElse(null);

		if (existingSong != null) {
			// Actualizar los campos cancion existente
			existingSong.setName(updatedSong.getName());
			existingSong.setArtist(updatedSong.getArtist());
			existingSong.setClasificacion(updatedSong.getClasificacion());

			// Guardar los cambios en el repositorio
			repo.save(existingSong);
		}

		// Redirigir a la página de listado de canciones
		return "redirect:/dashboard";
	}

	@GetMapping("/search")
	public String search(@RequestParam(name = "q") String query, Model model) {
	    Set<Song> matchingSongsSet = new HashSet<>();
	    
	    matchingSongsSet.addAll(songService.findByArtist(query)); // Buscar por artista
	    matchingSongsSet.addAll(songService.findByName(query)); // Buscar por nombre de canción
	    
	    List<Song> matchingSongs = new ArrayList<>(matchingSongsSet);
	    
	    model.addAttribute("songs", matchingSongs);
	    return "search"; // Nombre de la vista que muestra los resultados
	}


	@GetMapping("/songs/topten")
	public String search() {

		return "topten";
	}

	@GetMapping("/songs/new")
	public String agregar() {
		return "new";
	}

	@GetMapping("/songs/{id}")
	public String buscar(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "details"; //
	}
}