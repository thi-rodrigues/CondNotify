package com.trsystems.service.impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trsystems.exception.NegocioException;
import com.trsystems.model.Morador;
import com.trsystems.model.mapper.MoradorMapper;
import com.trsystems.model.record.MoradorRecord;
import com.trsystems.repository.MoradorRepository;
import com.trsystems.service.MoradorService;

import jakarta.validation.Valid;

@Service
public class MoradorServiceImpl implements MoradorService {
	
	private static final Logger log = LoggerFactory.getLogger(MoradorServiceImpl.class);
	
	@Autowired
	private MoradorMapper moradorMapper; 
	@Autowired
	private MoradorRepository moradorRepository;

	@Override
	public MoradorRecord create(@Valid MoradorRecord moradorRecord) {
		try {
			log.info("INICIO - Criar um morador");
			Morador morador = moradorMapper.toEntity(moradorRecord);
			morador.setDataCriacao(LocalDateTime.now());
			morador.setAtivo('S');
			Morador moradorSave = moradorRepository.save(morador);
			log.info("Morador cadastrado com sucesso!");
			log.info("FIM - Criar um morador");
			return moradorMapper.toMorador(moradorSave);
		} catch (Exception e) {
			log.error("Erro ao criar morador!");
			throw new NegocioException("Erro ao criar morador!" + e);
		}
	}
	
	@Override
	public Morador findById(Long id) {
		return moradorRepository.findById(id).orElseThrow(
				() -> new NegocioException("Morador não encontrado!" ));	
	}

}
