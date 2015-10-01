package com.hoangphan.check03c_sens;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SensitiveActivity extends Activity {

	private ImageButton btnSens;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensitive);
	
		//binding view
		btnSens = (ImageButton) findViewById(R.id.btnSens);
	}
	
	public void changeSensitive(View v){
		Drawable drawable = getResources().getDrawable(R.drawable.bite);
		btnSens.setImageDrawable(drawable);
	}
}
