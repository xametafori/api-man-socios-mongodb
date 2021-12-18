package com.ms.practica2.service;

import com.ms.practica2.models.Socio;
import java.util.List;


public interface SocioService {

	 List<Socio> findAll();
	Socio findById(String dni);
	Socio save(Socio item);
}
