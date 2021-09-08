package dev.ascenio.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ascenio.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
	
}
