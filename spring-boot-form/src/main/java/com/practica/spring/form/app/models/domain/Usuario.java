package com.practica.spring.form.app.models.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Usuario {
	
	private String id;
	@NotEmpty(message = "No puede ser vacio")
	private String nombre;
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Size(min=3 ,max=8) //Validaciones de tamaño
	private String username;
	
	@NotEmpty
	@Size(min=6, max=15)
	private String password;
	
	@NotEmpty
	@Email
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
