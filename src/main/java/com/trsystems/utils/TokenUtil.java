package com.trsystems.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.trsystems.model.Users;

@Service
public class TokenUtil {
	
	public static String usuarioLogado() {
		Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return users.getLogin();
	}

}
