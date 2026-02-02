package com.tyss.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Author {
	@Id
	@Column(name = "author_id")
	private int id;

	@Column(name = "author_name")
	private String name;

	@Column(name = "author_phone")
	private long phone;

	@Column(name = "author_email")
	private String email;

	@CreationTimestamp
	private LocalDateTime creationDate;

	@UpdateTimestamp
	private LocalDateTime updatedDate;

	@OneToMany(mappedBy = "author", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	List<Book> books;

	public Author() {
	}

	public Author(int id, String name, long phone, String email) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

}
