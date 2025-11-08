package com.trsystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trsystems.model.record.MoradorRecord;
import com.trsystems.service.MoradorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/morador")
public class MoradorController {
	
	@Autowired
	private MoradorService moradorService;

	@PostMapping("/register")
	public ResponseEntity<MoradorRecord> registerMorador(@RequestBody @Valid MoradorRecord moradorRecord) {
		return ResponseEntity.status(HttpStatus.CREATED).body(moradorService.create(moradorRecord));
	}
}
