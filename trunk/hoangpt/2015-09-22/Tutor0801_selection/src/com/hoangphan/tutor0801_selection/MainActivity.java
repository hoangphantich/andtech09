package com.hoangphan.tutor0801_selection;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button1= (Button) findViewById(R.id.button1);
		Button button2= (Button) findViewById(R.id.button2);
		
		SelectClicker cliker = new SelectClicker(this);
		button1.setOnClickListener(cliker);
		button2.setOnClickListener(cliker);
	}
}
