package com.hoangphan.check02f_bankin_1;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listMoney;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//find UI
		listMoney = (ListView) findViewById(R.id.listMoney);
		
	}
	
	public void showReport(View v){
		//set calculate into list view
		Bank b = new Bank(1000000, 12);
		ArrayList<String> listStrMoney = b.getListMoney();
		listMoney.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listStrMoney));
	}
}
