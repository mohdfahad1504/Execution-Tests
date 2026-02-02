package com.tyss.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.entity.Author;

public class DeleteAuthor {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Author author = em.find(Author.class, 33);
		
		if (author != null) {
			et.begin();
			em.remove(author);
			et.commit();
			System.out.println("Book Deleted");
		} else {
			System.out.println("Record Not Found");
		}
	}
}
