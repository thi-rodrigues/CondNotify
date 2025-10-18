package com.trsystems.model.record;

public record OrdersRecord(Long id, String recipient, String apartamentNumber, String apartamentTower, String carrier
		, String trackingCode) {
}
