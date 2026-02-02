package com.tyss.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.entity.Book;

public class UpdateBook {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Book book = em.find(Book.class, 9);
		
		if (book != null) {
			et.begin();
			book.setPrice(12000);
			em.merge(book);
			et.commit();
			System.out.println("Book Updated");
		} else {
			System.out.println("Record Not Found");
		}
	}
}
