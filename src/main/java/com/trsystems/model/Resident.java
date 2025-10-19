package com.trsystems.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RESIDENT")
public class Resident implements Serializable {
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
	
	@OneToMany(mappedBy = "resident", fetch = FetchType.LAZY)
	private List<Orders> orders;
	
	@Column(name = "DATA_CRIACAO")
	private LocalDateTime dataCriacao;
}
