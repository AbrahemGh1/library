/**#################################################################
 * 
 **#################################################################*/
package com.demo.hibernate.repo;

import java.io.File;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Query;

import com.demo.hibernate.entity.Book;
import com.demo.hibernate.utility.HibernateUtil;


public class BookRepository {
	
	public void saveBook(Book book){
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            System.out.println("Records inserted sucessessfully");
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
	
    public List<Book> getBooks(){
    	Session session = HibernateUtil.getSession(); 
        Query query = session.createQuery("from Book");
        List<Book> books =  query.list();
        session.close();
        return books;
    }
	
    
    public int updateBook(Book b){
    	System.out.println("change to "+b.getPrice());
        if(b.getId() <=0)  
              return 0;  
        	Session session = HibernateUtil.getSession(); 
           Transaction tx = session.beginTransaction();
           String hql = "update Book set name = :name, author=:author,price=:price where id = :id";
           Query query = session.createQuery(hql);
           query.setInteger("id",b.getId());
           query.setString("name",b.getTitle());
           query.setString("author",b.getAuthor());
           query.setDouble("price",b.getPrice());
           int rowCount = query.executeUpdate();
           
           System.out.println("Rows affected: " + rowCount);
           tx.commit();
           session.close();
           return rowCount;
   }
    
    public int deleteBook(int id) {

    	Session session = HibernateUtil.getSession(); 
        Transaction tx = session.beginTransaction();
        String hql = "delete from Book where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }

    public List<Book> getBookByName(String title ) {
    	  if(title.length() <=0)  
              return null;  
        	Session session = HibernateUtil.getSession(); 
           String hql = "from Book where name = :name";
           
           Query query = session.createQuery(hql);
           query.setString("name",title);
           List<Book> books =  query.list();
           session.close();
           return books;
    }
}
