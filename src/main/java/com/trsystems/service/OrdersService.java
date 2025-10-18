package com.trsystems.service;

import com.trsystems.model.record.OrdersRecord;

import jakarta.validation.Valid;

public interface OrdersService {

	OrdersRecord create(@Valid OrdersRecord orderRecord);

}
