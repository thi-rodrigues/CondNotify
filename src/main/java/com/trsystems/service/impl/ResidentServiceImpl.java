package com.trsystems.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trsystems.exception.NegocioException;
import com.trsystems.model.Resident;
import com.trsystems.model.mapper.ResidentMapper;
import com.trsystems.model.record.ResidentRecord;
import com.trsystems.repository.ResidentRepository;
import com.trsystems.service.ResidentService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResidentServiceImpl implements ResidentService {
	
	@Autowired
	private ResidentMapper residentMapper; 
	@Autowired
	private ResidentRepository residentRepository;

	@Override
	public ResidentRecord create(@Valid ResidentRecord residentRecord) {
		try {
			log.info("INICIO - Criar um morador");
			Resident resident = residentMapper.toEntity(residentRecord);
			resident.setDataCriacao(LocalDateTime.now());
			Resident residentSave = residentRepository.save(resident);
			log.info("Morador cadastrado com sucesso!");
			log.info("FIM - Criar um morador");
			return residentMapper.toResident(residentSave);
		} catch (Exception e) {
			log.error("Erro ao criar morador!");
			throw new NegocioException("Erro ao criar morador!" + e);
		}
	}
	
	@Override
	public Resident findById(Long id) {
		return residentRepository.findById(id).orElseThrow(
				() -> new NegocioException("Morador não encontrado!" ));	
	}

}
