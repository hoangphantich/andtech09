package com.example.christmas_color;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button btn_red, btn_green, btn_yellow;
	public RadioGroup group;
	public TextView color;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_red = (Button) this.findViewById(R.id.btn_red);
		btn_green = (Button) this.findViewById(R.id.btn_green);
		btn_yellow = (Button) this.findViewById(R.id.btn_yellow);
		
		color = (TextView) this.findViewById(R.id.color);
		

		// set color for buttom
		
		btn_red.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				color.setBackgroundColor(Color.RED);
			}

		});
		btn_green.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				color.setBackgroundColor(Color.GREEN);
			}

		});
		btn_yellow.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				color.setBackgroundColor(Color.YELLOW);
			}

		});
		RadioGroup group = (RadioGroup) this.findViewById(R.id.group);
		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				checkedId = group.getCheckedRadioButtonId();
				switch(checkedId) {
				case R.id.radio_red:
					color.setBackgroundColor(Color.RED);
					break;
				case R.id.radio_green: 
					color.setBackgroundColor(Color.GREEN);
					break;
				case R.id.radio_yellow: 
					color.setBackgroundColor(Color.YELLOW);
					break;
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
