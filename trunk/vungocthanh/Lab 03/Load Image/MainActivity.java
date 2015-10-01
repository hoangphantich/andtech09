package com.example.load_image;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	EditText edt_name;
	Button btn_show;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edt_name = (EditText) this.findViewById(R.id.edt_name);
		btn_show = (Button) this.findViewById(R.id.btn_show);
		btn_show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent("com.example.load_image.Image");
				String str = edt_name.getText().toString();
				intent.putExtra("str", str);
				startActivity(intent);
	
				
				 
			}
		});
	}
	
	

}
