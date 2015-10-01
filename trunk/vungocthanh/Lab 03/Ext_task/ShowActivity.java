package com.example.ext_task;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShowActivity extends Activity {

	ArrayList<Information> myArray;
	ArrayAdapter adapter;
	ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);  // gan voi activity thu 2
		
		list = (ListView) this.findViewById(R.id.listView1);
		
		ListInfo listInf = (ListInfo) getIntent().getBundleExtra("bundle")
				.getSerializable("list");
		myArray = listInf.getMyArray();
		
		ShowAdapter adapter = new ShowAdapter(this, R.layout.showitem, myArray);  // showitem la ten xml
		list.setAdapter(adapter);
	}

}
