package com.example.state_info;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity2 extends Activity {
	Button btnAc1s, btnAc2s, btnAc3s;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);

		btnAc3s = (Button) findViewById(R.id.btnAc3s);
	}

	protected void onStart() {
		super.onStart();
		btnAc3s.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						Activity3.class);
				startActivity(intent);

			}
		});
	}
}
