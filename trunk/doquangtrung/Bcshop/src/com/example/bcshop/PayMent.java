package com.example.bcshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PayMent extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment);
		Intent i = getIntent();
		int a = i.getIntExtra("pshang", 0);
		TextView tx = (TextView) findViewById(R.id.textView1);
		if (a == 0) {
			tx.setText("Quần kaki");
		} else if (a == 1) {
			tx.setText("Ao sơ mi");
		} else if (a == 2) {
			tx.setText("Giầy nam");
		} else if (a == 3) {tx.setText("Váy");
		}
	}
}
