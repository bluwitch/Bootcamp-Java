package com.bootcamp.pyc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.pyc.models.Categoria;

@Repository
public interface CategoriaRepositorio extends CrudRepository<Categoria, Long> {

	List<Categoria> findAll();

}