package com.ajinkya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajinkya.entity.BookEntity;

public interface BookRepo extends JpaRepository<BookEntity, Integer> {

	List<BookEntity> findByBookStatus(String bookStatus);
}
