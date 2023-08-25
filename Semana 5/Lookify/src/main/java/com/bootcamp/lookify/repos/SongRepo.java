package com.bootcamp.lookify.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.lookify.models.Song;

@Repository
public interface SongRepo extends CrudRepository<Song, Long> {

	//Busca todas las canciones
	public List<Song> findAll();

	//Busca una canción según el artista
	List<Song> findByArtist(String artist);

	public List<Song> findByName(String name);

}
