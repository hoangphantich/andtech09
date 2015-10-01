package com.example.west_journey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Src3Activity extends Activity {
	Button btn_go_main_3;
	Spinner spin1, spin2;
	ArrayAdapter<String> adapter1, adapter2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_src3);
		String arr1[] = { "IBM", "Facebook", "Google" };
		String arr2[] = { "Ha Noi", "NewYork", "Tokyo" };
		btn_go_main_3 = (Button) this.findViewById(R.id.btn_go_main_3);

		adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, arr1);
		adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, arr2);
		spin1 = (Spinner) this.findViewById(R.id.spin1);
		spin2 = (Spinner) this.findViewById(R.id.spin2);

		adapter1.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
		spin1.setAdapter(adapter1);
		adapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
		spin2.setAdapter(adapter2);

		btn_go_main_3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bundle bundle = new Bundle();
				String txt_spin1 = spin1.getSelectedItem().toString();
				String txt_spin2 = spin2.getSelectedItem().toString();
				Intent back = new Intent();
				back.putExtra("txt_spin1", txt_spin1);
				back.putExtra("txt_spin2",txt_spin2 );
				setResult(3,back);
				finish();
			}
		});
		
	}

	

}
