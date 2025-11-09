package com.trsystems.service.impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.trsystems.exception.NegocioException;
import com.trsystems.model.Morador;
import com.trsystems.model.filter.FilterMorador;
import com.trsystems.model.mapper.MoradorMapper;
import com.trsystems.model.record.MoradorRecord;
import com.trsystems.repository.MoradorRepository;
import com.trsystems.service.MoradorService;
import com.trsystems.utils.PageRequestUtil;

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
			log.info("INICIO - Criando um morador");
			Morador morador = moradorMapper.toMorador(moradorRecord);
			morador.setDataCriacao(LocalDateTime.now());
			morador.setAtivo('S');
			morador.setBloco(morador.getBloco().toUpperCase());
			Morador moradorSave = moradorRepository.save(morador);
			log.info("Morador cadastrado com sucesso!");
			log.info("FIM - Criar um morador");
			return moradorMapper.toRecord(moradorSave);
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

	@Override
	public Page<MoradorRecord> moradores(int page, int size, String sort, String sortDirection,
			FilterMorador filterMorador) {
		PageRequest requisicaoPaginada = PageRequestUtil.obterRequisicaoPaginada(page, size, sort, sortDirection);
		Page<Morador> moradores = moradorRepository.buscarMoradores(requisicaoPaginada);
		return moradores.map(morador -> moradorMapper.toRecord(morador));
	}

}
