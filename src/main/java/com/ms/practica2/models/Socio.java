package com.ms.practica2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "Socio")
public class Socio {

	@Id
	private String dni;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private String telefono;
	private Integer estado;
	private String tipoMembresia;
	private Integer port;


}
