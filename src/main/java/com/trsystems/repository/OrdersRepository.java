package com.trsystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trsystems.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
