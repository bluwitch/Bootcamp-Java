package com.bootcamp.students.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcamp.students.models.Info;
import com.bootcamp.students.repositories.InfoRepository;

@Service
public class ContactService {

	private final InfoRepository contactoRepositorio;

	public ContactService(InfoRepository contactoRepositorio) {
		this.contactoRepositorio = contactoRepositorio;
	}

	public Info CrearContacto(Info c) {
		return contactoRepositorio.save(c);
	}

	public List<Info> TodosLosContactos() {
		return contactoRepositorio.findAll();
	}

}