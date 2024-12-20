package com.ajinkya.controller;

import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ajinkya.entity.BookEntity;
import com.ajinkya.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService service;
	
	@GetMapping("/")
	public ModelAndView showBooks()
	{
		ModelAndView m=new ModelAndView();
		m.addObject("books",service.getBooks());
		m.addObject("book",new BookEntity());
		m.setViewName("index");
		return m;
	}
	
	@PostMapping("/save_book")
	public ModelAndView saveBook(BookEntity b)
	{
		ModelAndView modelAndView=new ModelAndView();
		b.setBookStatus("Active");
		
		Boolean s= service.saveBook(b);
		if(s)
		{
			modelAndView.addObject("successMsg","Book Inserted");
		}
		else {
			modelAndView.addObject("errorMsg","Book Not Inserted");
		}
		
		modelAndView.addObject("books",service.getBooks());
		modelAndView.addObject("book",new BookEntity());
		
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@GetMapping("/delete_book")
    public ModelAndView deleteBook(@RequestParam("id") Integer bookId) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("successMsg","Book Deleted Successfully");
		modelAndView.addObject("books",service.getBooks());
		modelAndView.addObject("book",new BookEntity());
		modelAndView.setViewName("index");
        service.deleteBook(bookId); 
        return modelAndView;
        
        }
	@GetMapping("/edit_book")
	public ModelAndView editBook(@RequestParam("id") Integer bookId)
	{
		ModelAndView modelAndView=new ModelAndView();
		BookEntity bookEntity=service.getBookById(bookId);
		modelAndView.addObject("book",bookEntity);
		modelAndView.addObject("books",service.getBooks());
		modelAndView.addObject("successMsg","Book Update Successfully");
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	
}
