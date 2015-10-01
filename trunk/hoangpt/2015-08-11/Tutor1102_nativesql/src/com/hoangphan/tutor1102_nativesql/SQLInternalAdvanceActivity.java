package com.hoangphan.tutor1102_nativesql;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SQLInternalAdvanceActivity extends Activity {

	private EditText edtName;
	private ListView lstPeople;
	private ArrayAdapter<String> adapter;
	private EditText edtAge;
	private Spinner spnNation;
	private SQLiteDatabase db;
	
	private ArrayList<String> nations;
	private ArrayList<String> infos;
	private EditText edtId;
	
	{ //dynamic init
		nations = new ArrayList<>();
		nations.add("Vietnam");
		nations.add("English");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlinternal_advance);
		
		//bind view
		_bindView();
		
		//read from SQLite
		_readDB();
	}

	private void _readDB() {
		//connect to database |>create
		db = this.openOrCreateDatabase( "myfriendadv.sqlite3", MODE_PRIVATE, null);
		
		//create table |>transaction
		db.beginTransaction();
		Cursor cursor = null;
		try {
			String createTble = "CREATE TABLE IF NOT EXISTS user ("
					 +"id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
					 +"name TEXT, age INTEGER, nationId INTEGER);";
			db.execSQL(createTble);
			
			//query |> cursor
			String sql = "SELECT * FROM user";
			cursor = db.rawQuery(sql, null);			

			//perform your database operations here ...
			db.setTransactionSuccessful(); //commit your changes catch (SQLiteException e) {
		} finally { 
			db.endTransaction();
		}
		
		//parser cursors
		infos = new ArrayList<>();
		if(cursor.getCount() > 0){
			while (!cursor.isLast()) {
				cursor.moveToNext(); //cursor |1
				
				int id = cursor.getInt(0);
				String name = cursor.getString(1); //column = 0
				String age = cursor.getString(2);
				int nationId = cursor.getInt(3);
				String nation = nations.get(nationId);
				infos.add(id+"|"+name+"|"+age+"|"+nation);
			}
		}
		
		adapter.addAll(infos);
		adapter.notifyDataSetChanged();		
	}

	private void _bindView() {
		edtId = (EditText) findViewById(R.id.edtId);
		edtName = (EditText) findViewById(R.id.edtNameAdv);
		edtAge = (EditText) findViewById(R.id.edtAgeAdv);
		spnNation = (Spinner) findViewById(R.id.spnNationAdv);
		
		lstPeople = (ListView) findViewById(R.id.lstPeopleAdv);
		
		adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
		lstPeople.setAdapter(adapter);
		
		lstPeople.setOnItemClickListener(new UserListener());
	}
	
	class UserListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			TextView tv = (TextView) view;
			String infoStr = tv.getText().toString();
			String[] infoArr = infoStr.split("\\|");
			
			edtId.setText(infoArr[0]);
			edtName.setText(infoArr[1]);
			edtAge.setText(infoArr[2]);
			//spnNation.setSelection(Integer.parseInt(infoArr[3]));
		}
	}
	
	public void addPerson(View v){
		//get  name from ui
		String name = edtName.getText().toString();
		String age = edtAge.getText().toString();
		int nationId = spnNation.getSelectedItemPosition();
		String nation = nations.get(nationId);
		
		//write into db
		String insertSQL = "INSERT INTO user VALUES (null, '"+name+"', "+age+", "+nationId+")";
		db.execSQL(insertSQL);
		
		//get last insert id
		String query = "SELECT seq from SQLITE_SEQUENCE WHERE name='user' limit 1";
		Cursor c = db.rawQuery(query, null);
		long lastId = 0;
		if (c != null && c.moveToFirst()) {
		    lastId = c.getLong(0); //The 0 is the column index, we only have 1 column, so the index is 0
		}		
		
		//change UI
		adapter.add(lastId+"|"+name+"|"+age+"|"+nation);
		adapter.notifyDataSetChanged();
		
		//notice
		edtName.setText("");
		edtAge.setText("");
		spnNation.setSelection(0);
		Toast.makeText(this, "Insert OK", 0).show();
	}	
	
	public void updatePerson(View v){
		//get  name from ui
		int id = Integer.parseInt(edtId.getText().toString());
		
		String name = edtName.getText().toString();
		String age = edtAge.getText().toString();
		int nationId = spnNation.getSelectedItemPosition();
		
		String updateSQL = "UPDATE user SET name='"+name+"', age="+age+", nationId ="+nationId+" WHERE id="+id;
		db.execSQL(updateSQL);
	}
}
