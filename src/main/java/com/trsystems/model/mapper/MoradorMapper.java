package com.trsystems.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.trsystems.model.Morador;
import com.trsystems.model.record.MoradorRecord;

@Mapper(componentModel = "spring")
public interface MoradorMapper {
	MoradorMapper INSTANCE = Mappers.getMapper(MoradorMapper.class);

	MoradorRecord toRecord(Morador entity);

	Morador toMorador(MoradorRecord moradorRecord);
}
