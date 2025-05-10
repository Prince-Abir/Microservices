package com.orderService.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem {
	
	@Id
	@Column(name = "order_item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String itemName;
	
	private int quantity;
	
	private String size; //S,M,L,XL,XXL
	
	private String color; //White, Black, Green
	
	private double price;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	@JsonBackReference
	private Order order;


	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderItem(long id, String itemName, int quantity, String size, String color, double price, Order order) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.size = size;
		this.color = color;
		this.price = price;
		this.order = order;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", itemName=" + itemName + ", quantity=" + quantity + ", size=" + size
				+ ", color=" + color + ", price=" + price + ", order=" + order + "]";
	}
	
	
	

}
