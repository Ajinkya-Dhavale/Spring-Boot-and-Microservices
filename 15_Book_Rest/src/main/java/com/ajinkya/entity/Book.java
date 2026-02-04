package com.ajinkya.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="book_rest")
public class Book {
	@Id
	private Integer book_id;
	
	@Column(name="book_name")
	private String bookName;
	
	@Column(name="book_pric")
	private Double bookPrice;

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return bookName;
	}

	public void setBook_name(String book_name) {
		this.bookName = book_name;
	}

	public Double getBook_price() {
		return bookPrice;
	}

	public void setBook_price(Double book_price) {
		this.bookPrice = book_price;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + bookName + ", book_price=" + bookPrice + "]";
	}
	
}
 