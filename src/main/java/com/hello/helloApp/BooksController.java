package com.hello.helloApp;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Lists;
import com.hello.helloApp.dto.ApplicationBooks;
import com.hello.helloApp.dto.Book;
import com.hello.helloApp.dto.SessionBooks;

@Controller
@Scope("request")
public class BooksController {

	private List<Book> books;
	@Autowired
	private ApplicationBooks applicationBooks;
	@Autowired
	private SessionBooks sessionBooks;

	@PostConstruct
	public void postConstruct() {
		Book a = new Book("BookA");
		Book b = new Book("BookB");
		books = Lists.newArrayList(a, b);
	}

	@RequestMapping(value = "/viewdata", method = RequestMethod.GET)
	public void view(Model model) {
		List<Book> all = Lists.newArrayList();
		all.addAll(books);
		all.addAll(sessionBooks.getBooks());
		all.addAll(applicationBooks.getBooks());
		model.addAttribute("books", all);
	}
	
	@RequestMapping(value = "/viewdata/{bookName}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable String bookName) {
		List<Book> all = Lists.newArrayList();
		all.addAll(books);
		all.addAll(sessionBooks.getBooks());
		all.addAll(applicationBooks.getBooks());
		all.add(new Book(bookName));
		model.addAttribute("books", all);
		return "viewdata";
	}

	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String addNewBook() {
		return "addbook";
	}

	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String addNewBook(@RequestParam String bookName, @RequestParam String op) {
		Book b = new Book(bookName);
		if (op.equals("Add To App"))
			applicationBooks.addBook(b);
		else if (op.equals("Add To Session"))
			sessionBooks.addBook(b);
		else if (op.equals("Add To Request")) {
			books.add(b);
			return "redirect:viewdata/" + bookName;
		}

		return "redirect:home";
	}
}
