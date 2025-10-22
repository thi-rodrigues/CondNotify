package com.trsystems.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.trsystems.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter { // ACONTECE UMA VEZ A CADA REQUISIÇÃO
	
	@Autowired
	private TokenService tokenService;
	@Autowired
	private UserRepository userRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// PEGAR O TOKEN, E VERIFICAR AS INFORMAÇÃO DE DENTRO DELE
		var token = recoverToken(request);
		
		if ( token != null ) {
			String login = tokenService.validateToken(token);
			UserDetails user = userRepository.findByLogin(login);
			
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user,  null, user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authenticationToken); // Gravar a autenticação no contexto do spring
		}
		
		filterChain.doFilter(request, response); // chama o próximo filtro
	}

	private String recoverToken(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization");
		if ( authHeader == null )
			return null;
		
		return authHeader.replace("Bearer ", "");
	} 

}
