package dev.ascenio.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ascenio.dsvendas.dto.SellerDTO;
import dev.ascenio.dsvendas.services.SellerService;

@RestController
@RequestMapping("/sellers")
public class SellerController {
	@Autowired
	private SellerService service;
	
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll() {
		var sellers = service.findAll();
		return ResponseEntity.ok(sellers);
	}
}
