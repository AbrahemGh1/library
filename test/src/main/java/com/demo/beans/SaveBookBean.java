package com.demo.beans;

import com.demo.hibernate.entity.Book;
import com.demo.hibernate.repo.BookRepository;

public class SaveBookBean {
	private Book toSaveBook;
	private BookRepository  bookRepository= new BookRepository();
	

	public Book getB() {
		return toSaveBook;
	}

	public void setB(Book b) {
		this.toSaveBook = b;
	}
	
	public void saveBook() {
		bookRepository.saveBook(toSaveBook);
		
	}
	
	public boolean canBeSaved() {
		if(toSaveBook.getAuthor()!=null || toSaveBook.getName() !=null)
			return true;
		return false;
		
	}

	

}
