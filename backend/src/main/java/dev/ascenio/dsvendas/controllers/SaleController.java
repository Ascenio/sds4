package dev.ascenio.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ascenio.dsvendas.dto.SaleDTO;
import dev.ascenio.dsvendas.dto.SalesSuccessDTO;
import dev.ascenio.dsvendas.dto.SalesSumDTO;
import dev.ascenio.dsvendas.services.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		var sales = service.findAll(pageable);
		return ResponseEntity.ok(sales);
	}
	
	@GetMapping("/ammount-by-seller")
	public ResponseEntity<List<SalesSumDTO>> ammountBySeller() {
		var sales = service.ammountBySeller();
		return ResponseEntity.ok(sales);
	}

	@GetMapping("/success-by-seller")
	public ResponseEntity<List<SalesSuccessDTO>> successBySeller() {
		var reports = service.successBySeller();
		return ResponseEntity.ok(reports);
	}
}
