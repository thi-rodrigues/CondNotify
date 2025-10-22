package com.trsystems.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.trsystems.exception.NegocioException;
import com.trsystems.model.Users;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;

	public String generateToken(Users user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret); // ALGORITIMO DE GERAÇÃO DE TOKEN
			return JWT.create()
					.withIssuer("auth-api-condNotify") // QUEM CRIOU O TOKEN(PARA IDENTIFICAR A APLICAÇÃO)
					.withSubject(user.getLogin()) // USUARIO QUE ESTÁ RECEBENDO O TOKEN
					.withExpiresAt(generationExpirationDate()) // EXPIRAÇÃO DO TOKEN
					.sign(algorithm);
		} catch (JWTCreationException e) {
			throw new NegocioException("Error while generation token" + e);
		}
	}
	
	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret); // ALGORITIMO DE GERAÇÃO DE TOKEN
			return JWT.require(algorithm)
					.withIssuer("auth-api-condNotify")
					.build()
					.verify(token)
					.getSubject(); // Retornar o login
		} catch (TokenExpiredException e) {
			// REFRESH TOKEN
			throw new NegocioException("Token expirado!");
		} catch (JWTVerificationException e) {
			return "";
		}
	}
	
	private Instant generationExpirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
//		return LocalDateTime.now().plusMinutes(1).toInstant(ZoneOffset.of("-03:00")); // TODO: usar refresh token
	}
}
