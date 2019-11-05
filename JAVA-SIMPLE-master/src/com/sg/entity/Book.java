package com.sg.entity;
import com.sg.column;
import com.sg.Table;

@Table(name = "books")
public class Book {
	
	private int id;
	
	private String title;
	
	private double price;

	public Book() {
	}
	
	@column(name = "book_id", type = "NUMERIC(10)")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@column(name = "Title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@column(name = "Amount", type = "NUMERIC(12,2)")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Book(int id, String title, double price) {
		this.id = id;
		this.title = title;
		this.price = price;
	}
}
