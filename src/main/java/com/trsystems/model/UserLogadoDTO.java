package com.trsystems.model;

import com.trsystems.model.enums.UsersRoles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogadoDTO {
	private String nome;
	private UsersRoles role;
	private String token;
}
