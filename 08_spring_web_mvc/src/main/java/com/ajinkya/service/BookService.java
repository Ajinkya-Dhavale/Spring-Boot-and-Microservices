package com.ajinkya.service;

import java.util.List;

import com.ajinkya.entity.BookEntity;


public interface BookService {
	public List<BookEntity> getBooks();

	public void deleteBook(Integer bookId);

	public Boolean saveBook(BookEntity b);
	
	public BookEntity getBookById(Integer id);
}
