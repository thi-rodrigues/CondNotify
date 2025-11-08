package com.trsystems.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.trsystems.model.Users;
import com.trsystems.model.record.UserLogadoRecord;

@Mapper(componentModel = "spring")
public interface UserLogadoMapper {
	UserLogadoMapper INSTANCE = Mappers.getMapper(UserLogadoMapper.class);

	UserLogadoRecord toUserLogadoRecord(Users users);

	Users toUsers(UserLogadoRecord userLogadoRecord);
}
