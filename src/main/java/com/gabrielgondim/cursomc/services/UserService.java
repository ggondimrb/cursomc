package com.gabrielgondim.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.gabrielgondim.cursomc.security.UserSS;

//classe para retornar o usuario logado
public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}

}
