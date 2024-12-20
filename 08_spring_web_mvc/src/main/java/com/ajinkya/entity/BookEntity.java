package com.ajinkya.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "book_tbl")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer bookId;
	
	@Column(name="book_name")
	public String bookName;
	
	@Column(name="book_author")
	public String bookAuthor;

	@Column(name="book_price")
	public Double bookPrice;

	@Column(name="book_status")
	public String bookStatus;

	public void setBookStatus(String string) {
		bookStatus=string;
		
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	@Override
	public String toString() {
		return "BookEntity [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPrice="
				+ bookPrice + ", bookStatus=" + bookStatus + "]";
	}
	
}
