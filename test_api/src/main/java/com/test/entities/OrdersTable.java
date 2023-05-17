package com.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class OrdersTable {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "customer_id")
	private String name;
	
	@Column(name = "total_price")
	private Double total_price;
	
	@Column(name = "create_at")
	private String create_at;
	
}
