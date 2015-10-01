package com.hoangphan.tutor1102_nativesql;

import java.util.List;

import com.hoangphan.tutor1102_nativesql.model.User;
import com.hoangphan.tutor1102_nativesql.model.UserManager;

import android.app.ListActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SQLAdvanceTwoActivity extends ListActivity {

	private ArrayAdapter<User> adapter;
	private UserManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		SQLiteDatabase db = openOrCreateDatabase("myfriendadv.sqlite3", MODE_PRIVATE, null);
		manager = new UserManager(db);
	
		_bindView();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		List<User> users = manager.listUser();
		_dataBinding(users);
	}

	private void _dataBinding(List<User> users) {
		adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, users);
		setListAdapter(adapter);
	}

	private void _bindView() {
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long idView) {
		Intent i = new Intent(this, UserActivity.class);
		User user = adapter.getItem(position);
		
		//i.putExtra("user", user);
		Log.d("viewid", idView+"|hahaha");
		i.putExtra("id", user.id);
		startActivity(i);
	}
}
