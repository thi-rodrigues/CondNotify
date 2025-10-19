package com.trsystems.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.trsystems.model.Resident;
import com.trsystems.model.record.ResidentRecord;

@Mapper(componentModel = "spring")
public interface ResidentMapper {
	ResidentMapper INSTANCE = Mappers.getMapper(ResidentMapper.class);

	ResidentRecord toResident(Resident entity);

	Resident toEntity(ResidentRecord residentRecord);
}
