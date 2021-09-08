package dev.ascenio.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ascenio.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
}
