package com.trsystems.service.impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trsystems.exception.NegocioException;
import com.trsystems.model.Morador;
import com.trsystems.model.Orders;
import com.trsystems.model.enums.StatusOrders;
import com.trsystems.model.mapper.OrdersMapper;
import com.trsystems.model.record.OrdersRecord;
import com.trsystems.repository.OrdersRepository;
import com.trsystems.service.MoradorService;
import com.trsystems.service.OrdersService;
import com.trsystems.utils.TokenUtil;

import jakarta.validation.Valid;

@Service
public class OrderServiceImpl implements OrdersService {
	
	private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrdersMapper ordersMapper; 
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private MoradorService moradorService;
	@Autowired
	private TokenUtil tokenUtil;

	@Override
	public OrdersRecord create(@Valid OrdersRecord ordersRecord) {
		try {
			log.info("INICIO - Criar registro de encomenda");
			System.out.println(tokenUtil.usuarioLogado());;
			Orders order = ordersMapper.toEntity(ordersRecord);
			order.setDataCriacao(LocalDateTime.now());
			order.setStatus(StatusOrders.PENDING);
			Morador morador = moradorService.findById(ordersRecord.moradorId());
			order.setMorador(morador);
			Orders orderSave = ordersRepository.save(order);
			log.info("Encomenda registrada com sucesso!");
			log.info("FIM - Criar registro de encomenda");
			return ordersMapper.toRecord(orderSave);
		} catch (Exception e) {
			log.error("Erro ao registrar encomenda!");
			throw new NegocioException("Erro ao registrar encomenda! " + e.getMessage());
		}
	}

}
