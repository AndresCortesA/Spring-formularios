package com.practica.spring.form.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.practica.spring.form.app.models.domain.Usuario;


//estas son expresiones personalizadas para las advertencias	
@Component //para inyectarlo en el controlador y validar
public class UsuarioValidador implements Validator {

	@Override //sobreescribir
	public boolean supports(Class<?> clazz) {
		//El objeto que estamos validando corresponda al tipo Usuario
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Usuario usuario = (Usuario)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "requerido.usuario.nombre");
		//otra alternativa
		/*
		 if(usuario.getNombre().isEmpty()){
		 
		 errors.rejectValue("nombre", "NotEmpty.usuario.nombre");
		 
		 }
		 */
		//validar que los valores del id esten en el rango de los valores dados
		if(usuario.getId().matches("[0-9]{3}[:][0-9]{3}[_][a-zA-Z]{1}") == false) {
			errors.rejectValue("id", "pattern.usuario.id");
		}

	}

}
