package com.trsystems.model.record;

import com.trsystems.model.enums.UsersRoles;

public record UserLogadoRecord(String nome, UsersRoles role, String token) {

}
