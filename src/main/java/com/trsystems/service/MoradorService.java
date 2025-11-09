package com.trsystems.service;

import org.springframework.data.domain.Page;

import com.trsystems.model.Morador;
import com.trsystems.model.filter.FilterMorador;
import com.trsystems.model.record.MoradorRecord;

import jakarta.validation.Valid;

public interface MoradorService {

	MoradorRecord create(@Valid MoradorRecord moradorRecord);

	Morador findById(Long id);

	Page<MoradorRecord> moradores(int page, int size, String sort, String sortDirection, FilterMorador filterMorador);
}
