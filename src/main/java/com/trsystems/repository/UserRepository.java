package com.trsystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.trsystems.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	UserDetails findByLogin(String login);
}
