package com.trsystems.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLRestriction("ativo = 'S'")
@Entity
@Table(name = "MORADOR")
public class Morador implements Serializable {

	private static final long serialVersionUID = -3219343909171178640L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "BLOCO")
	private String bloco;
	
	@Column(name = "APARTAMENTO")
	private String apartamento;
	
	@OneToMany(mappedBy = "morador", fetch = FetchType.LAZY)
	private List<Orders> orders;
	
	@Column(name = "DATA_CRIACAO")
	private LocalDateTime dataCriacao;
	
	@Column(name = "ATIVO")
	private Character ativo;
}
