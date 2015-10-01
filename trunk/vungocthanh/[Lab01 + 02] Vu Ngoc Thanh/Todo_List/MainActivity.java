package com.example.ba_tung;

import java.util.ArrayList;
import java.util.Collections;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	EditText input;
	EditText input_hour;
	EditText input_minute;
	Button btn_add;
	ListView list;
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		input = (EditText) this.findViewById(R.id.input);
		input_hour = (EditText) this.findViewById(R.id.input_hour);
		input_minute = (EditText) this.findViewById(R.id.input_minute);
		btn_add = (Button) this.findViewById(R.id.btn_add);
		list = (ListView) this.findViewById(R.id.listView1);
		
		// Tao Adapter va gan vao listview
		final ArrayList<String> arr = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, arr);
		list.setAdapter(adapter);

		// su kien khi click vao item cua listview
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, 
					long arg3) {
				// arg2 la vi tri cua item trong ListView
				// TODO Auto-generated method stub
				arr.remove(arg2);
				adapter.notifyDataSetChanged();
			}
		});

		// su kien them vao khi an vao buttom add	
		btn_add.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (input.getText().toString().equals("")
						|| input_hour.getText().toString().equals("")
						|| input_minute.getText().toString().equals("")) {
					new AlertDialog.Builder(MainActivity.this)
							.setTitle("Warning")
							.setMessage(
									"You work or ... either blank \nYou must enter right word")
							.setPositiveButton("Ok",
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
											// TODO Auto-generated method stub

										}
									}).create().show();
				} else {
					String str = input_hour.getText().toString() + ":"
							+ input_minute.getText().toString() + " - "
							+ input.getText().toString() + ".";
					arr.add(str);
					Collections.sort(arr);
					adapter.notifyDataSetChanged();
					input.setText("");
					input_hour.setText("");
					input_minute.setText("");
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
