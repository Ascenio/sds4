package dev.ascenio.dsvendas.dto;

import java.io.Serializable;

import dev.ascenio.dsvendas.entities.Seller;

public class SellerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public SellerDTO(Seller seller) {
		this.id = seller.getId();
		this.name = seller.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
