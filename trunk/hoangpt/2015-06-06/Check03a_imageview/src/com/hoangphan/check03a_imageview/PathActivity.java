package com.hoangphan.check03a_imageview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class PathActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_path);
	}
	
	public void viewDog(View v){
		String path = ((EditText) findViewById(R.id.edtPath)).getText().toString();
		Intent i = new Intent(this, ViewActivity.class);
		i.putExtra("path", path);
		
		startActivity(i);
	}
}
