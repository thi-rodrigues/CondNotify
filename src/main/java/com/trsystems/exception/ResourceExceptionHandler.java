package com.trsystems.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.trsystems.service.impl.ResidentServiceImpl;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(ResidentServiceImpl.class);

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Error> negocioException(NegocioException n) {
		Error error = new Error(LocalDateTime.now(), n.getMessage());
		log.error(error.toString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
