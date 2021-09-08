package dev.ascenio.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ascenio.dsvendas.dto.SellerDTO;
import dev.ascenio.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll() {
		return repository.findAll().stream().map(SellerDTO::new).toList();
	}
}
