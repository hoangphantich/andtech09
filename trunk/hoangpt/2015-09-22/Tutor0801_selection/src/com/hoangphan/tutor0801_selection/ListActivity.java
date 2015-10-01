package com.hoangphan.tutor0801_selection;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		String[] lists = new String[] {
				"Mai", "Ngoc", "Phuong"
		};
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, 
				android.R.layout.simple_list_item_2, 
				android.R.id.text1, lists);
		
		ListView listView1 = (ListView) findViewById(R.id.listView1);
		listView1.setAdapter(adapter);
	}
}
