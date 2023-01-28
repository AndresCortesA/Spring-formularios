package com.practica.spring.form.app.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practica.spring.form.app.models.domain.Usuario;

import jakarta.validation.Valid;

@Controller
public class FormController {
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Andres");
		usuario.setApellido("Arias");
		usuario.setId("2432354234pk");
		//debemos agregar un usuario por defecto para evitar un nullpointer
		model.addAttribute("titulo","Formulario");
		model.addAttribute("usuario",usuario);
		return "form";
	}
	
	//obtiene los datos del formulario
	@PostMapping("/form")
//	public String recibir(Model model,
//			@RequestParam String username,
//			@RequestParam String password,
//			@RequestParam String email) {
//		//Clase POJO una clase entity que representa datos, no es una clase con logica no es necesario DI
//		//inyeccion de dependencia
//		Usuario usuario = new Usuario();
//		
	//esta seria una forma de hacerlo, pero es mejor mapear los datos del usuario,ya que queda más limpio
//		usuario.setUsername(username);
//		usuario.setEmail(email);
//		usuario.setPassword(password);
//		
//		model.addAttribute("titulo","resultado");
//		model.addAttribute("usuario", usuario);
//		return "resultado";
//	}
	
	//mucho más limpío y automatizado, ya que se envia el usuario y se pueblan los datos
	//crearemos también validaciones mediante spring y no del cliente con html
	public String recibir(@Valid Usuario usuario, BindingResult result, Model model) {
		//BindingResult debe estar siempre después del objeto que se valida, esto es para validar de forma manual
		//crearemos otra parte del proyecto donde lo hagamos más automatico con thymeleaf
		model.addAttribute("titulo", "Resultado del formulario mapeando");
		
//		if(result.hasErrors()) {
//			Map<String, String> errores = new HashMap<>();
//			result.getFieldErrors().forEach(err->{
//				errores.put(err.getField(), "El campo ".concat(err.getField().concat(" ").concat(err.getDefaultMessage())));
//			});
//			model.addAttribute("errores", errores);
//			return "form";
//		}
		if(result.hasErrors()) {
			return "form";
		}
		
		model.addAttribute("usuario", usuario);
		
		return "resultado";
	}
	
}
