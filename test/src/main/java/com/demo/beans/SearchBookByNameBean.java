package com.demo.beans;

import java.util.List;

import com.demo.hibernate.entity.Book;
import com.demo.hibernate.repo.BookRepository;

public class SearchBookByNameBean {
	BookRepository bookRepository= new BookRepository();
	private String bookName;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public List<Book> searchResult() {
		return bookRepository.getBookByName(bookName);
	}
	
	

}
