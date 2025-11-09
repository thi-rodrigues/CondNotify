package com.trsystems.model.record;

import com.trsystems.model.enums.UsersRoles;

public record UserRegisterRecord(String login, String nome, String password, UsersRoles role) {

}
