package com.hoangphan.check03f_news.service;

import java.util.ArrayList;
import java.util.List;

import com.hoangphan.check03f_news.model.Article;

public class StaticData {
	
	public static List<Article> getAllArticles(){
		//add 3 articles
		ArrayList<Article> articles = new ArrayList<>();
		articles.add(new Article(1, "ban dam", "blablalabl ban dam"));
		articles.add(new Article(2, "6 nguoi headshot", "blablalabl headshot"));
		articles.add(new Article(3, "nu tho dan ban nude", "blablalabl ban nude"));
		
		return articles;
	}

}
