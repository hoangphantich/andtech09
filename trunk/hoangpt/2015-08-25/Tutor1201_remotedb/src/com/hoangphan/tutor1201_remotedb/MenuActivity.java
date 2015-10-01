package com.hoangphan.tutor1201_remotedb;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MenuActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//get menu item from array (in XML)
		String[] list = getResources().getStringArray(R.array.list_menu);
		
		//set into adapter data, list-item
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.title, list);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		//get name of menu
		String nameOfClass = ((TextView) v.findViewById(R.id.title)).getText().toString();
		String packageName = getApplicationContext().getPackageName();
		
		//gotoactivity correspoding menu
		//reflection
		Class<?> className =  null;
		try {
			className = Class.forName(packageName+"."+nameOfClass+"Activity");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		startActivity(new Intent(this, className));
	}
	
	
}
