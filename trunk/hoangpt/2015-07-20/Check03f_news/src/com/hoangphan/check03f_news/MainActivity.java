package com.hoangphan.check03f_news;

import java.util.ArrayList;
import java.util.List;

import com.hoangphan.check03f_news.model.Article;
import com.hoangphan.check03f_news.service.StaticData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener {

	private List<Article> articles;
	private ListView listArticle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//list article
		articles = StaticData.getAllArticles();
		
		//bind data view (native, model binding (orm), helper)
		listArticle = (ListView) findViewById(R.id.listArticle);
		
		ArrayAdapter<String> adapArticle = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
		//ArrayAdapter<Article> adapArticle = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
		
		//extract title from object
		//ArrayList<String> titleArticles = _extractTitle(articles);
		ArrayList<String> titleArticles = new ArrayList<String>();
		for (Article article : articles) {
			titleArticles.add(article.getTitle());
		}
		
		adapArticle.addAll(titleArticles);
		
		//set adapter
		listArticle.setAdapter(adapArticle);
		listArticle.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		//instead push object
		Intent iToDetail = new Intent(this, DetailActivity.class);
		iToDetail.putExtra("id", position+1);
		Log.d("id", position+1+"");
		startActivity(iToDetail);
	}
}
