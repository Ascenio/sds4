package dev.ascenio.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.ascenio.dsvendas.dto.SalesSuccessDTO;
import dev.ascenio.dsvendas.dto.SalesSumDTO;
import dev.ascenio.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	@Query("SELECT new dev.ascenio.dsvendas.dto.SalesSumDTO(obj.seller, SUM(obj.ammount)) "
		 + "FROM Sale AS obj GROUP BY obj.seller")
	List<SalesSumDTO> ammountBySeller();
	
	@Query("SELECT new dev.ascenio.dsvendas.dto.SalesSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			 + "FROM Sale AS obj GROUP BY obj.seller")
	List<SalesSuccessDTO> successBySeller();
}
