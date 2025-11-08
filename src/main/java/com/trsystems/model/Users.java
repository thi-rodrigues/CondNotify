package com.trsystems.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.trsystems.model.enums.UsersRoles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class Users implements Serializable, UserDetails {
	private static final long serialVersionUID = -617744172176055212L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ROLE")
	@Enumerated(EnumType.STRING)
	private UsersRoles role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.role == UsersRoles.ADMIN)
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getUsername() {
		return login;
	}

}
