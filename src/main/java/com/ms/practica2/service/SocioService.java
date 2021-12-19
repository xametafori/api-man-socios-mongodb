package com.ms.practica2.service;

import com.ms.practica2.models.Socio;
import java.util.List;
import java.util.Optional;


public interface SocioService {

	List<Socio> findAll();
	Optional<Socio> findById(String dni);
	Socio save(Socio item);
	void delete(String dni);
	boolean existsById(String dni);
}
