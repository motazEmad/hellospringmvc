package com.hello.helloApp;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Lists;
import com.hello.helloApp.dto.Book;

@Controller
public class BooksController {
	
	private List<Book> books;
	
	@PostConstruct
	public void postConstruct() {
		Book a = new Book("BookA");
		Book b = new Book("BookB");
		books = Lists.newArrayList(a,b); 
	}
	
	@RequestMapping(value = "/viewdata", method = RequestMethod.GET)
	public void view(Model model) {
		model.addAttribute("books", books);
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String addNewBook() {
		return "addbook";
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String addNewBook(@RequestParam String bookName) {
		Book b = new Book(bookName);
		books.add(b);
		return "redirect:home";
	}
}
