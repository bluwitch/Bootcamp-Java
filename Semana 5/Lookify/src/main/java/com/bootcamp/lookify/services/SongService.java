package com.bootcamp.lookify.services;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bootcamp.lookify.models.Song;
import com.bootcamp.lookify.repos.SongRepo;

import jakarta.transaction.Transactional;

@Service
public class SongService {
	private final SongRepo songRepo;

	public SongService(SongRepo songRepo) {
		this.songRepo = songRepo;
	}

	// Retornar todas las canciones
	public List<Song> allCanciones() {
		return songRepo.findAll();
	}

	// Crear canción
	public Song crearCancion(Song c) {
		return songRepo.save(c);
	}

	// Buscar canción y retornala si existe, sino return = null
	public Song findSong(Long id) {
		Optional<Song> optionalCancion = songRepo.findById(id);
		if (optionalCancion.isPresent()) {
			return optionalCancion.get();
		} else {
			return null;
		}
	}

	// Buscar cancion por artista
	public List<Song> findByArtist(String artist) {
		return songRepo.findByArtist(artist);
	}

	// Eliminar canción
	public void deleteSong(Long id) {
		if (songRepo.existsById(id)) {
			songRepo.deleteById(id);
		} else {
			throw new NoSuchElementException("No se encontró el elemento con id " + id);
		}
	}

	// Editar canción
	@Transactional
	public void updateSong(Song song) {
		Song existingSong = songRepo.findById(song.getId()).orElse(null);
		if (existingSong != null) {
			existingSong.setName(song.getName());
			existingSong.setArtist(song.getArtist());
			existingSong.setClasificacion(song.getClasificacion());
			// Guardar los cambios en la base de datos
			songRepo.save(existingSong);
		}
	}

	// Encontrar las 10 canciones con el rango mas alto
	public List<Song> createTop10() {
		List<Song> allSongs = songRepo.findAll();

		// Ordena las listas en orden descendiente teniendo en cuenta la clasificación
		List<Song> sortedSongs = allSongs.stream().sorted(Comparator.comparingInt(Song::getClasificacion).reversed())
				.collect(Collectors.toList());

		return sortedSongs.subList(0, Math.min(sortedSongs.size(), 10));
	}

	public List<Song> findByName(String name) {
		return songRepo.findByName(name); // Cambio de findByArtist a findByName
	}
}