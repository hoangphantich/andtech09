package com.example.check03e;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class MenuActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		String[] list = getResources().getStringArray(R.array.list_menu);
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.title, list);
		setListAdapter(adapter);
	}
}
