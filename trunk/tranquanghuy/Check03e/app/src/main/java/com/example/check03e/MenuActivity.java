package com.example.check03e;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MenuActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		String[] list = getResources().getStringArray(R.array.list_menu);
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.title, list);
		setListAdapter(adapter);
	}

	@Override
	protected  void onListItemClick(ListView l, View v, int position, long id){
		String nameTextView = ((TextView) v.findViewById(R.id.title)).getText().toString();

		Class<?> cls =null;
		try {
			cls = Class.forName("com.example.check03e."+ nameTextView+"Activity");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		startActivity(new Intent(this, cls));
	}
}
