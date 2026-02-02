package com.tyss.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyss.entity.Author;
import com.tyss.entity.Book;

public class FetchByBook {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Book book = em.find(Book.class, 1);
		
		if (book != null) {
			System.out.println("--------Book------");
			System.out.println("Id : " + book.getId());
			System.out.println("Name : " + book.getName());
			System.out.println("Pages : " + book.getPages());
			System.out.println("Price : " + book.getPrice());
			
			Author author = book.getAuthor();
			System.out.println("--------Author---------");
			System.out.println("Id : " + author.getId());
			System.out.println("Name : " + author.getName());
			System.out.println("Phone : " + author.getPhone());
			System.out.println("Email : " + author.getEmail());
		} else {
			System.out.println("Record Not Found");
		}
	}
}
