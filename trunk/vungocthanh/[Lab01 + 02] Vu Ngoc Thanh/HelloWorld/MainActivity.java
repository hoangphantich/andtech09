package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public Button Enter;
	public EditText et;
	public TextView ht;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		Enter = (Button) this.findViewById(R.id.button1); // Gan ten cho button1
		et = (EditText) this.findViewById(R.id.editText1); //
		ht = (TextView) this.findViewById(R.id.textView1);
		
		Enter.setOnClickListener(new OnClickListener() { // set su kien click vao nut button
			
			@Override
			public void onClick(View v) {  // su kien khi click vao button
				String str =  " Welcome Andorid World , " + et.getText().toString();		
				
				ht.setText( str ); // hien thi sau khi click -> set lai text
				
			}
		});
		
	}

	
}
