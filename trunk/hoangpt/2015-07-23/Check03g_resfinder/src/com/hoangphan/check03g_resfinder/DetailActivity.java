package com.hoangphan.check03g_resfinder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		ListView lstRes = (ListView) findViewById(R.id.lstRes);
		String[] resNames = getResources().getStringArray(R.array.resnames);
		ArrayAdapter<String> adapRes = new ArrayAdapter<>(this, R.layout.item_restaurant, R.id.txtName, resNames);
		lstRes.setAdapter(adapRes);
	}
}
