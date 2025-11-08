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
	private String name;
	
	@Column(name = "APARTAMENT_NUMBER")
	private String apartamentNumber;
	
	@Column(name = "APARTAMENT_TOWER")
	private String apartamentTower;
	
	@OneToMany(mappedBy = "morador", fetch = FetchType.LAZY)
	private List<Orders> orders;
	
	@Column(name = "DATA_CRIACAO")
	private LocalDateTime dataCriacao;
	
	@Column(name = "ATIVO")
	private Character ativo;
	
	public Morador() {
		super();
	}

	public Morador(Long id, String name, String apartamentNumber, String apartamentTower, List<Orders> orders,
			LocalDateTime dataCriacao, Character ativo) {
		super();
		this.id = id;
		this.name = name;
		this.apartamentNumber = apartamentNumber;
		this.apartamentTower = apartamentTower;
		this.orders = orders;
		this.dataCriacao = dataCriacao;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApartamentNumber() {
		return apartamentNumber;
	}

	public void setApartamentNumber(String apartamentNumber) {
		this.apartamentNumber = apartamentNumber;
	}

	public String getApartamentTower() {
		return apartamentTower;
	}

	public void setApartamentTower(String apartamentTower) {
		this.apartamentTower = apartamentTower;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Character getAtivo() {
		return ativo;
	}

	public void setAtivo(Character ativo) {
		this.ativo = ativo;
	}
	
	
}
