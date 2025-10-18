package com.trsystems.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Error> negocioException(NegocioException n) {
		Error error = new Error(LocalDateTime.now(), n.getMessage());
		log.error(error.toString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
