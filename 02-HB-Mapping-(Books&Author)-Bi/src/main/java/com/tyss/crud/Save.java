package com.tyss.crud;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.entity.Author;
import com.tyss.entity.Book;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Author author = new Author(33, "Manga", 98754673L, "Manga@gmail.com");
		Book b1 = new Book("MangaStory", 460.0, 170);
		Book b2 = new Book("MangaLife", 650.0, 330);
		Book b3 = new Book("MangaFamily", 850.0, 460);

		b1.setAuthor(author);
		b2.setAuthor(author);
		b3.setAuthor(author);
		author.setBooks(Arrays.asList(b1, b2, b3));

		et.begin();
		em.persist(author);
		et.commit();
		System.out.println("Record Inserted");
	}
}
