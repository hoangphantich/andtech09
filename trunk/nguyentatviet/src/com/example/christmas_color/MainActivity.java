package com.example.christmas_color;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnred = (Button) findViewById(R.id.btnred);
		Button btngreen = (Button) findViewById(R.id.btngreen);
		Button btnyeloow = (Button) findViewById(R.id.btnyellow);
		final TextView view = (TextView) findViewById(R.id.textView1);
		final RadioButton rtd = (RadioButton) findViewById(R.id.radioButton1);
		btnred.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				view.setBackgroundColor(Color.RED);
			}
		});
		btngreen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				view.setBackgroundColor(Color.GREEN);
			}
		});
		btnyeloow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				view.setBackgroundColor(Color.YELLOW);
			}
		});
		rtd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				view.setBackgroundColor(Color.RED);
			}
		});
	}

}
