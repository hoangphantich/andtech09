package com.hoangphan.check02h_bikenr;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BikenrActivity extends Activity {

	private EditText edtNr1;
	private EditText edtNr2;
	private EditText edtNr3;
	private TextView edtWarning;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bikenr);
		
		_bindUIToVariable();
	}

	private void _validateBikeNr() {
		String str1 = edtNr1.getText().toString(); 
		String str2 = edtNr2.getText().toString(); 
		String str3 = edtNr3.getText().toString();
		
		if(BikenrValidator.checkNr1(str1) &&
				BikenrValidator.checkNr2(str2) &&
				BikenrValidator.checkNr3(str3)
				){
			//bien hop le
			//extract city code
			CittynrExtractor extractor = new CittynrExtractor();
			Integer cityCode = extractor.extractData(str1);
			
			//check cityCode
			if(null !=extractor.getCity(cityCode)){
				//bien hop le va co ma thang pho
				Toast.makeText(this, "Hop le", 1).show();
			} else {
				//bien k hop le
				Toast.makeText(this, "Khong hop le vi khong co thanh pho", 1).show();
			}
			
		} else {
			//bien k hop le
			
		}
	}

	private void _bindUIToVariable() {
		edtNr1 = (EditText) findViewById(R.id.edtNr1);
		edtNr2 = (EditText) findViewById(R.id.edtNr2);
		edtNr3 = (EditText) findViewById(R.id.edtNr3);
		
		edtWarning = (TextView) findViewById(R.id.edtWarning);
	}
	
	public void checkNr(View v){
		_validateBikeNr();
	}
}
