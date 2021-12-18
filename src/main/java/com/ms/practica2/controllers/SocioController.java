package com.ms.practica2.controllers;

import com.ms.practica2.models.Socio;
import com.ms.practica2.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SocioController {
	
	@Autowired
	private SocioService itemService;
	
	@GetMapping("/socio")
	public List<Socio> listar(){
		return itemService.findAll();
	}
	
	@GetMapping("/socio/{id}")
	public Socio detalle(@PathVariable String dni) {
		return itemService.findById(dni);
	}
	@PostMapping("/socio")
	public Socio grabarPersona(@RequestBody Socio socio)	{
		Socio oSocio=itemService.save(socio);
		return oSocio;
	}

}
