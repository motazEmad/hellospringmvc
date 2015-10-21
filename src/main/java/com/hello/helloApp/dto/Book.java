package com.hello.helloApp.dto;

import java.util.Date;

public class Book {

	private String name;
	private Date addedTime;

	public Book() {
		
	}
	
	public Book(String name) {
		this.name = name;
		this.addedTime = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getAddedTime() {
		return addedTime;
	}

	public void setAddedTime(Date addedTime) {
		this.addedTime = addedTime;
	}

}
