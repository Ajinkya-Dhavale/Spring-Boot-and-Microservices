package com.ajinkya.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajinkya.entity.BookEntity;
import com.ajinkya.repository.BookRepo;

@Service
public class BookServiceImp implements BookService{

	@Autowired
	private BookRepo repo;
	@Override
	public List<BookEntity> getBooks() {
		List<BookEntity> books=repo.findByBookStatus("active");
		return books;
	}
	
	
	
	@Override
	public void deleteBook(Integer bookId) {
	    Optional<BookEntity> optionalBookEntity = repo.findById(bookId);

	    if (optionalBookEntity.isPresent()) {
	        BookEntity bookEntity = optionalBookEntity.get();
	        bookEntity.setBookStatus("disactive");
	        repo.save(bookEntity);
	    } else {
	        throw new RuntimeException("Book not found with ID: " + bookId);
	    }
	}



	@Override
	public Boolean saveBook(BookEntity b) {
		BookEntity bookEntity=repo.save(b);
		return bookEntity.getBookId()!=null;
	}



	@Override
	public BookEntity getBookById(Integer id) {
		Optional<BookEntity> optional=repo.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

}
