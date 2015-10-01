package com.hoangphan.check03d;

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
		
		String[] menuList = new String[]{
				"CheckMotoNr", "SolveMath", "BuildTowel"
		};
		MenuAdapter adapter = new MenuAdapter(this, R.layout.list_item, menuList);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		//get name
		String name = ((TextView) v.findViewById(R.id.title)).getText().toString();
		Class<?> cls = null;
		try {
			cls = Class.forName("com.hoangphan.check03d."+name+"Act");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//startActivity
		startActivity(new Intent(this, cls));
		
		
	}
}
