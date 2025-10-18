package com.trsystems.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.trsystems.model.record.OrdersRecord;

@Mapper(componentModel = "spring")
public interface OrdersMapper {
	OrdersMapper INSTANCE = Mappers.getMapper(OrdersMapper.class);

    OrdersRecord toRecord(Orders entity);

    Orders toEntity(OrdersRecord ordersRecord);
}
