package com.example.christcolor_lab2;

import java.security.acl.Group;

import android.R.color;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
	private Button btnRed, btnGreen, btnYellow;
	private RadioButton radRed, radGreen, radYellow, rad;
	View view1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnRed = (Button) findViewById(R.id.btnRed);
		btnGreen = (Button) findViewById(R.id.btnGreen);
		btnYellow = (Button) findViewById(R.id.btnYellow);
		radRed = (RadioButton) findViewById(R.id.radRed);
		radGreen = (RadioButton) findViewById(R.id.radGreen);
		radYellow = (RadioButton) findViewById(R.id.radYellow);

		view1 = findViewById(R.id.view1);
		btnRed.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				view1.setBackgroundColor(Color.RED);

			}
		});
		btnGreen.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				view1.setBackgroundColor(Color.GREEN);

			}
		});
		btnYellow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				view1.setBackgroundColor(Color.YELLOW);

			}
		});
		radRed.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				view1.setBackgroundColor(Color.RED);

			}
		});
		radGreen.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				view1.setBackgroundColor(Color.GREEN);

			}
		});
		radYellow.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				view1.setBackgroundColor(Color.YELLOW);

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
