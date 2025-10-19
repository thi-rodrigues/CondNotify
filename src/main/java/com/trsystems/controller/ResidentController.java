package com.trsystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trsystems.model.record.ResidentRecord;
import com.trsystems.service.ResidentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/resident")
public class ResidentController {
	
	@Autowired
	private ResidentService residentService;

	@PostMapping("/register")
	public ResponseEntity<ResidentRecord> registerResident(@RequestBody @Valid ResidentRecord residentRecord) {
		return ResponseEntity.status(HttpStatus.CREATED).body(residentService.create(residentRecord));
	}
}
