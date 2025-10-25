package com.trsystems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.trsystems.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	Optional<UserDetails> findByLogin(String login);
}
