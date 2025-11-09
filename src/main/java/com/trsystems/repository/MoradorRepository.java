package com.trsystems.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trsystems.model.Morador;

public interface MoradorRepository extends JpaRepository<Morador, Long>{

	@Query(value = "FROM Morador f WHERE 1=1")
	Page<Morador> buscarMoradores(Pageable requisicaoPaginada);

}
