package com.demo.hibernate.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.demo.hibernate.entity.Book;
import com.demo.hibernate.repo.BookRepository;


@Path("books")
public class BookRecourses {
    public static final String CLICHED_MESSAGE = "Hello World!";
    private BookRepository bookRepository= new BookRepository();
    
 // if there is no book
@GET
@Produces(MediaType.APPLICATION_JSON)
    public Response getBooks() {
	return Response.ok(bookRepository.getBooks()).build();
    }


   // if there is no book
@GET
@Path("/{bookName}")
@Produces(MediaType.APPLICATION_JSON)
    public Response getBooksFiltered(@PathParam("bookName") String bookName) {
	return Response.ok(bookRepository.getBookByName(bookName)).build();
    }
//    public Response getBooksFiltered(@PathParam("bookTitle") String title) {

@POST
@Produces(MediaType.APPLICATION_JSON)
	public Response addBook(Book book) {
	bookRepository.saveBook(book);
	    return Response.ok().build();
	}



    //if book does not exist 
@PUT
@Produces(MediaType.APPLICATION_JSON)
	public Response editBook(Book book) {
	bookRepository.updateBook(book);
	     return Response.ok().build();
	}




    //if book does not exist 
@DELETE
@Produces(MediaType.APPLICATION_JSON)
	public Response DeleteBook(Book book) {
	bookRepository.deleteBook(book.getId());
	     return Response.ok().build();
	}
}
