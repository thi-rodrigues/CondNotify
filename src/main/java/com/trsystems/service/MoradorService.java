package com.trsystems.service;

import com.trsystems.model.Morador;
import com.trsystems.model.record.MoradorRecord;

import jakarta.validation.Valid;

public interface MoradorService {

	MoradorRecord create(@Valid MoradorRecord moradorRecord);

	Morador findById(Long id);

}
