package dev.ascenio.dsvendas.dto;

import java.io.Serializable;
import java.time.LocalDate;

import dev.ascenio.dsvendas.entities.Sale;

public class SaleDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private int visited;
	private int deals;
	private double ammount;
	private LocalDate date;
	private SellerDTO sellerDTO;
	
	public SaleDTO(Sale sale) {
		id = sale.getId();
		visited = sale.getVisited();
		deals = sale.getDeals();
		ammount = sale.getAmmount();
		date = sale.getDate();
		sellerDTO = new SellerDTO(sale.getSeller());
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public int getVisited() {
		return visited;
	}

	public int getDeals() {
		return deals;
	}

	public double getAmmount() {
		return ammount;
	}

	public LocalDate getDate() {
		return date;
	}

	public SellerDTO getSellerDTO() {
		return sellerDTO;
	}
}
