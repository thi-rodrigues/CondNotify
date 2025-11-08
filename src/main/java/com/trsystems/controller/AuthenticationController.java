package com.trsystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trsystems.model.UserLogadoDTO;
import com.trsystems.model.Users;
import com.trsystems.model.mapper.UserLogadoMapper;
import com.trsystems.model.record.AuthenticationRecord;
import com.trsystems.model.record.UserLogadoRecord;
import com.trsystems.repository.UserRepository;
import com.trsystems.security.AuthenticationService;
import com.trsystems.security.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenService tokenService;

	@PostMapping("/login")
	public ResponseEntity<UserLogadoDTO> login(@RequestBody @Valid AuthenticationRecord authenticationRecord) {
		var userNamePassword = new UsernamePasswordAuthenticationToken(authenticationRecord.login(), authenticationRecord.password());
		var auth = this.authenticationService.authenticate(userNamePassword);
		String token = tokenService.generateToken((Users) auth.getPrincipal());
		UserLogadoRecord userLogado = UserLogadoMapper.INSTANCE.toUserLogadoRecord((Users) auth.getPrincipal());
		UserLogadoDTO userLogadoDTO = new UserLogadoDTO(userLogado.nome(), userLogado.role(), token);
		return ResponseEntity.ok(userLogadoDTO);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid UserRegisterRecord userRegisterRecord) {
		if ( (userRepository.findByLogin(userRegisterRecord.login()) != null) ) 
			return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(userRegisterRecord.password());
		Users newUser = new Users(null, userRegisterRecord.login(), userRegisterRecord.nome(), encryptedPassword, userRegisterRecord.role());
		this.userRepository.save(newUser);
		return ResponseEntity.ok().build();
	}
}
