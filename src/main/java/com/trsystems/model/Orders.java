package com.trsystems.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDERS")
public class Orders implements Serializable {

	private static final long serialVersionUID = -44466114255204403L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@JoinColumn(name = "RESIDENT_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Resident resident;
	
	@Column(name = "CARRIER")
	private String carrier;
	
	@Column(name = "TRACKING_CODE")
	private String trackingCode;
	
	@Column(name = "DATA_CRIACAO")
	private LocalDateTime dataCriacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private StatusOrders status;
	
}
