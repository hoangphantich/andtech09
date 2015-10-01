package com.hoangphan.check03f_news.model;

//entity
public class Article {
	long id;
	String title;
	String content;
	
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Article(long id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}



	@Override
	public String toString() {
		return title;
	}
	
	
	
	
}
