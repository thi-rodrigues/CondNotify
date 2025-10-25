package com.trsystems.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.trsystems.exception.NegocioException;

@Service
public class AuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;

	public Authentication authenticate(UsernamePasswordAuthenticationToken userNamePassword) {
		try {
			return this.authenticationManager.authenticate(userNamePassword);
		} catch (BadCredentialsException e) {
			throw new NegocioException("Senha inválida!");
		}
	}

}
