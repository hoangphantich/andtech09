package com.hoangphan.check03f_news;

import java.util.Iterator;
import java.util.List;

import com.hoangphan.check03f_news.model.Article;
import com.hoangphan.check03f_news.service.StaticData;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends Activity {

	private TextView edtTitle;
	private TextView edtContent;
	private List<Article> articles;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		//bind ui into variale
		_bindUI();
		
		//get articles
		articles = StaticData.getAllArticles();
		
		//get id of article from main
		int idArticleClick = getIntent().getIntExtra("id", 1);
		
		//display textview
		Article article = _findActicleUsingDrain(idArticleClick);
		edtTitle.setText(article.getTitle());
		edtContent.setText(article.getContent());
	}

	private Article _findActicleUsingDrain(long idArticleClick) {
		for (Article article: articles) {
			if(article.getId() == idArticleClick){
				return article;
			}
		}
		
		return null;
	}

	private void _bindUI() {
		edtTitle = (TextView) findViewById(R.id.edtTitle);
		edtContent = (TextView) findViewById(R.id.edtContent);
	}
}
