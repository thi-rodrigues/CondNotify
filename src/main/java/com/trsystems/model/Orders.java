package com.trsystems.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@Column(name = "RECIPIENT")
	private String recipient;
	
	@Column(name = "APARTAMENT_NUMBER")
	private String apartamentNumber;
	
	@Column(name = "APARTAMENT_TOWER")
	private String apartamentTower;
	
	@Column(name = "CARRIER")
	private String carrier;
	
	@Column(name = "TRACKING_CODE")
	private String trackingCode;
	
}
