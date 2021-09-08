package dev.ascenio.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.ascenio.dsvendas.dto.SaleDTO;
import dev.ascenio.dsvendas.dto.SalesSuccessDTO;
import dev.ascenio.dsvendas.dto.SalesSumDTO;
import dev.ascenio.dsvendas.repositories.SaleRepository;
import dev.ascenio.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		return saleRepository.findAll(pageable).map(SaleDTO::new);
	}
	
	@Transactional(readOnly = true)
	public List<SalesSumDTO> ammountBySeller() {
		return saleRepository.ammountBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SalesSuccessDTO> successBySeller() {
		return saleRepository.successBySeller();
	}
}
