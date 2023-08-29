package com.bootcamp.pyc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.pyc.models.Productos;

@Repository
public interface ProductosRepositorio extends CrudRepository<Productos,Long> {

    List<Productos> findAll();

}