package dev.ascenio.dsvendas.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sales")
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int visited;
	private int deals;
	private double ammount;
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private Seller seller;
	
	public Sale(Long id, int visited, int deals, double ammount, LocalDate date, Seller seller) {
		this.id = id;
		this.visited = visited;
		this.deals = deals;
		this.ammount = ammount;
		this.date = date;
		this.seller = seller;
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
}
