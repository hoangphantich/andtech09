package com.hoangphan.tutor1102_nativesql;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class NativeSQLExternalActivity extends Activity {

	private ListView lstPeople;
	private EditText edtName;
	private ArrayAdapter<Object> adapter;
	private ArrayList<Object> names;
	private SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_native_sqlexternal);
		
		//bind view
		_bindView();
		
		//read from SQLite
		_readDB();
	}

	private void _readDB() {
		//connect to database
		db = SQLiteDatabase.openDatabase( "/sdcard/Download/test.db",
				null, SQLiteDatabase.CREATE_IF_NECESSARY);
		
		//query -> cursor
		String sql = "SELECT name FROM user";
		Cursor cursor = db.rawQuery(sql, null);
		
		//parser cursors
		names = new ArrayList<>();
		while (!cursor.isLast()) {
			cursor.moveToNext(); //cursor -1
			
			String name = cursor.getString(0); //column = 0
			names.add(name);
		}
		
		adapter.addAll(names);
		adapter.notifyDataSetChanged();
	}

	private void _bindView() {
		edtName = (EditText) findViewById(R.id.edtName);
		lstPeople = (ListView) findViewById(R.id.lstPeople);
		
		adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
		lstPeople.setAdapter(adapter);
	}
	
	public void addPerson(View v){
		//get  name from ui
		String name = edtName.getText().toString();
	
		//write into db
		String insertSQL = "INSERT INTO user VALUES (null, '"+name+"')";
		db.execSQL(insertSQL);
		
		//change UI
		adapter.add(name);
		adapter.notifyDataSetChanged();
		
		//notice
		edtName.setText("");
		Toast.makeText(this, "Insert OK", 0).show();
		
	}
}
