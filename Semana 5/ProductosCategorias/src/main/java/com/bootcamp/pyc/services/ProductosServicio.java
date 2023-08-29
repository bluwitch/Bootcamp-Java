package com.bootcamp.pyc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.pyc.models.Categoria;
import com.bootcamp.pyc.models.Productos;
import com.bootcamp.pyc.repositories.ProductosRepositorio;

import jakarta.transaction.Transactional;

@Service
public class ProductosServicio {

	private final ProductosRepositorio productosRepositorio;

	public ProductosServicio(ProductosRepositorio productosRepositorio) {
		this.productosRepositorio = productosRepositorio;
	}

	public Productos addProd(Productos p) {
		return productosRepositorio.save(p);
	}

	public Productos encontrarPorId(Long id) {
		Optional<Productos> optionalProductos = productosRepositorio.findById(id);
		if (optionalProductos.isPresent()) {
			return optionalProductos.get();
		} else {
			return null;
		}
	}

    @Transactional
	public List<Productos> todosLosProductos() {
		List<Productos> todosLosProductos = productosRepositorio.findAll();
		for (Productos productos : todosLosProductos) {
			List<Categoria> categoria;
			categoria = productos.getCategorias();
			productos.setCategorias(categoria);
		}
		return productosRepositorio.findAll();
	}
    

}