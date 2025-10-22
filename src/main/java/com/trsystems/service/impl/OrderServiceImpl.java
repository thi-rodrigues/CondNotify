package com.trsystems.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trsystems.exception.NegocioException;
import com.trsystems.model.Orders;
import com.trsystems.model.Resident;
import com.trsystems.model.enums.StatusOrders;
import com.trsystems.model.mapper.OrdersMapper;
import com.trsystems.model.record.OrdersRecord;
import com.trsystems.repository.OrdersRepository;
import com.trsystems.service.OrdersService;
import com.trsystems.service.ResidentService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersMapper ordersMapper; 
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private ResidentService residentService;

	@Override
	public OrdersRecord create(@Valid OrdersRecord ordersRecord) {
		try {
			log.info("INICIO - Criar registro de encomenda");
			Orders order = ordersMapper.toEntity(ordersRecord);
			order.setDataCriacao(LocalDateTime.now());
			order.setStatus(StatusOrders.PENDING);
			Resident resident = residentService.findById(ordersRecord.residentId());
			order.setResident(resident);
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
