package com.hoangphan.check03c_sens_c2;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class SensActivity extends Activity {
	
	@Bind(R.id.edtWeight) EditText edtWeight;
	@Bind(R.id.edtMaximum) EditText edtMaximum;
	@Bind(R.id.spnCafe) Spinner spnCafe;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sens);
		ButterKnife.bind(this);
	}
	
	
	int starbuckNr, milkcafeNr, blackcafeNr;
	int gStarbuck = 1;
	int gMilkcafe = 5;
	int gBlackcafe = 10;
	
	@OnClick(R.id.button1)
	public void addCafein(View view) {
		int position = spnCafe.getSelectedItemPosition();
		Log.d("add", "Vao day chua:"+position);
		if(position==0){
			starbuckNr++;
		} else if(position==1){
			milkcafeNr++;
		} else {
			blackcafeNr++;
		}	
	}	
}
