package com.hoangphan.check02g;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	//hashmap (C2)
	//2 array (C3)
	int starbuckNr, milkcafeNr, blackcafeNr;
	int gStarbuck = 1;
	int gMilkcafe = 5;
	int gBlackcafe = 10;
	
	private EditText edtWeight, edtMaximum;
	int usedCafein = 0;
	private Spinner spnCafe;
	private TextView txtStarbuck;
	private TextView txtMilkCafe;
	private TextView txtBlackCafe;
	private TextView txtTotalInDay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//bind variable UI
		edtWeight = (EditText) findViewById(R.id.edtWeight);
		edtMaximum = (EditText) findViewById(R.id.edtMaximum);
		
		spnCafe = (Spinner) findViewById(R.id.spnCafe);
		txtStarbuck = (TextView) findViewById(R.id.txtStarback);
		txtMilkCafe = (TextView) findViewById(R.id.txtMilkCafe);
		txtBlackCafe = (TextView) findViewById(R.id.txtBlackCafe);
		txtTotalInDay = (TextView) findViewById(R.id.txtTotalInDay);
		
		//add textwatcher weight
		edtWeight.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				if(s.length() != 0){
					int weight = Integer.parseInt(s.toString());
					int maximum = ((100+weight)*1000 )/12000;
					edtMaximum.setText(maximum+"");
				}
			}
		});
	}
	
	public void addCafein(View v){
		int position = spnCafe.getSelectedItemPosition();
		Log.d("add", "Vao day chua:"+position);
		if(position==0){
			starbuckNr++;
			txtStarbuck.setText("Starbuck \t "+starbuckNr+" \t\t "+gStarbuck*starbuckNr+"mg");
			
			usedCafein+=gStarbuck;
			txtTotalInDay.setText(usedCafein+"mg");
		} else if(position==1){
			milkcafeNr++;
			txtMilkCafe.setText("MilkCafe \t "+milkcafeNr+" \t\t "+gMilkcafe*milkcafeNr+"mg");
			
			usedCafein+=gMilkcafe;
			txtTotalInDay.setText(usedCafein+"mg");
		} else {
			blackcafeNr++;
			txtBlackCafe.setText("BlackCafe \t "+blackcafeNr+" \t\t "+gBlackcafe*blackcafeNr+"mg");
			
			usedCafein+=gBlackcafe;
			txtTotalInDay.setText(usedCafein+"mg");
		}
	}
}
