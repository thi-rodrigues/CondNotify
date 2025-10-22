package com.trsystems.controller;

import com.trsystems.model.enums.UsersRoles;

public record UserRegisterRecord(String login, String password, UsersRoles role) {

}
