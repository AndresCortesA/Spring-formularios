package com.practica.spring.form.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import com.practica.spring.form.app.models.domain.Usuario;
import com.practica.spring.form.app.validation.UsuarioValidador;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario") //esto se guarda en una sesion http para mantenerlo de forma persistente durante la ejecucion
public class FormController {
	
	@Autowired
	private UsuarioValidador validador;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Andres");
		usuario.setApellido("Arias");
		//Usamos @SessionAttributes para mantener los datos del ID para evitar que el dato se pierda y quede en null
		usuario.setId("222:345_l");
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
	public String recibir(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		//BindingResult debe estar siempre después del objeto que se valida, esto es para validar de forma manual
		//crearemos otra parte del proyecto donde lo hagamos más automatico con thymeleaf
//		validador.validate(usuario, result);
		
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
		status.setComplete(); // se elimina el objeto usuario de la sesion
		return "resultado";
	}
	
}
