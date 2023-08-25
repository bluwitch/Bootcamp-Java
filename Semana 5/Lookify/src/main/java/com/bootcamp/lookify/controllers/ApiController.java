package com.bootcamp.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.lookify.models.Song;
import com.bootcamp.lookify.repos.SongRepo;
import com.bootcamp.lookify.services.SongService;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private SongService songService;

	@Autowired
	private SongRepo songRepo;

// Busca todas las canciones
	@GetMapping("/songs")
	public List<Song> listar() {
		return songRepo.findAll();
	}

// Busca una canción
	@GetMapping("/songs/{id}")
	public Song buscar(@PathVariable("id") Long id) {
		return songService.findSong(id);
	}

// Crea una canción
	@PostMapping("/songs")
	public void insertar(@RequestBody Song song) {
		songRepo.save(song);
	}

// Edita una canción
	@PutMapping("/songs/edit/{id}")
	public void editar(@PathVariable("id") Long id, @RequestBody Song song) {
		song.setId(id);
		songService.updateSong(song);
	}

// Borra una canción
	@DeleteMapping(value = "/songs/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		songRepo.deleteById(id);
	}

}