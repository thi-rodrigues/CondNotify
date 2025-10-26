package com.trsystems.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.trsystems.model.enums.StatusOrders;

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

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
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
	
	public Orders() {
		super();
	}
	
	public Orders(Long id, Resident resident, String carrier, String trackingCode, LocalDateTime dataCriacao,
			StatusOrders status) {
		super();
		this.id = id;
		this.resident = resident;
		this.carrier = carrier;
		this.trackingCode = trackingCode;
		this.dataCriacao = dataCriacao;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public StatusOrders getStatus() {
		return status;
	}

	public void setStatus(StatusOrders status) {
		this.status = status;
	}
	
}
