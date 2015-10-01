package com.example.multiplay_layout_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button btnMayTinh, btnImageView, btnSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnMayTinh = (Button) findViewById(R.id.btnMayTinh);
		btnImageView = (Button) findViewById(R.id.btnImage);
		btnSearch = (Button) findViewById(R.id.btnSeachImage1);

		
		btnSearch.setOnClickListener(this);
		btnMayTinh.setOnClickListener(this);
		btnImageView.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		Button btn = (Button) v;
		int id = btn.getId();
		
		if(id==R.id.btnMayTinh){
			Intent intent = new Intent(getApplicationContext(), Caculate.class);
			startActivity(intent);
		}
		else if(id==R.id.btnImage){
			Intent intent = new Intent(getApplicationContext(), ImageView1.class);
			startActivity(intent);
		}
		else if(id==R.id.btnSeachImage1){
			Intent intent = new Intent(getApplicationContext(), ImageViewSearch.class);
			startActivity(intent);
		}
		
	}

}
