package com.ajinkya.book.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ajinkya.book.dao.BookDAO;
import com.ajinkya.book.model.Book;

@Repository // Add this annotation
public class BookDAOImpl implements BookDAO {

    private final JdbcTemplate jdbcTemplate;

    public BookDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertBook(Book b) {
        String sql = "INSERT INTO book (id,name,price) VALUES (?, ? ,?)"; // Correct the table and column names
        jdbcTemplate.update(sql, b.getId(), b.getName(), b.getPrice()); // Use the correct Book properties
    }
}
