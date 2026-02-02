package com.tyss.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyss.entity.Author;
import com.tyss.entity.Book;

public class FetchByAuthor {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Author author = em.find(Author.class, 11);
		
		if (author != null) {
			System.out.println("--------Author---------");
			System.out.println("Id : " + author.getId());
			System.out.println("Name : " + author.getName());
			System.out.println("Phone : " + author.getPhone());
			System.out.println("Email : " + author.getEmail());
			
			List<Book> books = author.getBooks();
			System.out.println("---------Books---------");
			for(Book book : books) {
				System.out.println("Id : " + book.getId());
				System.out.println("Name : " + book.getName());
				System.out.println("Pages : " + book.getPages());
				System.out.println("Price : " + book.getPrice());
				System.out.println("===================================");
			}
			
		} else {
			System.out.println("Record Not Found");
		}
	}
}
