package com.bootcamp.pyc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.pyc.models.Categoria;
import com.bootcamp.pyc.models.Productos;
import com.bootcamp.pyc.repositories.CategoriaRepositorio;

import jakarta.transaction.Transactional;

@Service
public class CategoriaServicio {

	private final CategoriaRepositorio categoriaRepositorio;

	public CategoriaServicio(CategoriaRepositorio categoriaRepositorio) {
		this.categoriaRepositorio = categoriaRepositorio;
	}

	public Categoria addCat(Categoria c) {
		return categoriaRepositorio.save(c);
	}

	public Categoria encontrarPorId(Long id) {
		Optional<Categoria> optionalCategoria = categoriaRepositorio.findById(id);
		if (optionalCategoria.isPresent()) {
			return optionalCategoria.get();
		} else {
			return null;
		}
	}
    @Transactional
	public List<Categoria> allCat() {
		List<Categoria> todasLasCategorias = categoriaRepositorio.findAll();
		for (Categoria categoria : todasLasCategorias) {
			List<Productos> productos;
			productos = categoria.getProductos();
			categoria.setProductos(productos);
		}
		return categoriaRepositorio.findAll();
	}

}