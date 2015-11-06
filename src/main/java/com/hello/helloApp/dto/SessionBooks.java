package com.hello.helloApp.dto;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

@Component
@Scope("session")
public class SessionBooks {

	private List<Book> books = Lists.newArrayList();
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void addBook(Book b) {
		books.add(b);
	}
}
