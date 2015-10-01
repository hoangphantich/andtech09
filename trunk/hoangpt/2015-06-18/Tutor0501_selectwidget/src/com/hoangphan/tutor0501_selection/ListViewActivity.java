package com.hoangphan.tutor0501_selection;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		
		View v = this.findViewById(R.id.listCity);
		ListView listCity = null;
		if(v instanceof ListView){
			listCity = (ListView) v; //casting
		}
		
		String[] cities = new String[]{"Hanoi", "Saigon", "Hue", "Danang", "Cantho"};
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cities);
		
		if(null != listCity){
			listCity.setAdapter(adapter);
		}
	}
}
