package com.trsystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trsystems.model.filter.FilterMorador;
import com.trsystems.model.record.MoradorRecord;
import com.trsystems.service.MoradorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/morador")
public class MoradorController {
	
	@Autowired
	private MoradorService moradorService;

	@PostMapping("/cadastrar")
	public ResponseEntity<MoradorRecord> registerMorador(@RequestBody @Valid MoradorRecord moradorRecord) {
		return ResponseEntity.status(HttpStatus.CREATED).body(moradorService.create(moradorRecord));
	}
	
	@PostMapping("/todos")
//	@ApiOperation(value = "Buscar todos os moradores.")
	public ResponseEntity<Page<MoradorRecord>> moradores(
			@RequestParam(required = false, defaultValue = "0") int page, 
			@RequestParam(required = false, defaultValue = "10") int size,
			@RequestParam(required = false, defaultValue = "id") String sort,
			@RequestParam(required = false, defaultValue = "ASC") String sortDirection,
			@RequestBody FilterMorador filterMorador
			) {
		Page<MoradorRecord> moradores = moradorService.moradores(page, size, sort, sortDirection, filterMorador);
		return ResponseEntity.ok(moradores);
	}
}
