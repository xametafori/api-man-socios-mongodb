package com.ms.practica2.controllers;

import com.ms.practica2.models.Socio;
import com.ms.practica2.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class SocioController {

	@Value("${server.port}")
	private Integer port;

	@Autowired
	private SocioService itemService;

	@GetMapping("/socio")
	public List<Socio> listar(){
		return itemService.findAll().stream().map(socio ->{
			socio.setPort(port);
			return socio;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/socio/{dni}")
	public Optional<Socio> detalle(@PathVariable String dni) {
		Optional<Socio> socio=itemService.findById(dni);
		socio.get().setPort(port);
		return socio;
	}

	@PostMapping("/socio")
	public Socio grabarSocio(@RequestBody Socio socio)	{
		return itemService.save(socio);
	}

	@PutMapping("/socio/{dni}")
	public Optional<Socio> ActualizarSocio(@RequestBody Socio oSocio,@PathVariable String dni)	{
		Optional<Socio> optional = itemService.findById(dni);
		if (optional.isPresent()) {
			Socio socio = optional.get();
			socio.setApellidoPaterno(oSocio.getApellidoPaterno());
			socio.setApellidoMaterno(oSocio.getApellidoMaterno());
			socio.setCorreo(oSocio.getCorreo());
			socio.setEstado(oSocio.getEstado());
			socio.setNombre(oSocio.getNombre());
			socio.setTelefono(oSocio.getTelefono());
			socio.setTipoMembresia(oSocio.getTipoMembresia());
			itemService.save(socio);
		}

		return optional;
	}
	@DeleteMapping(value = "/socio/{dni}", produces = "application/json; charset=utf-8")
	public String deleteSocio(@PathVariable String dni) {
		boolean result = itemService.existsById(dni);
		if(result){
			itemService.delete(dni);
		}
		return "{ \"operacionExitosa\" : "+ (result ? "true" : "false") +" }";
	}

}
