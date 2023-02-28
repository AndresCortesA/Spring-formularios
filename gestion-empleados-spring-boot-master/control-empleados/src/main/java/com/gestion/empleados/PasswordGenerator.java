package com.gestion.empleados;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "coL_09-29";
		String encodedPassword = encoder.encode(rawPassword);
		
		System.out.println(encodedPassword);
		
	}
	
}
