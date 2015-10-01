package com.hoangphan.tutor0301_westernjourney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		
		//lay ra duoc cai intent
		Intent i = getIntent(); //intent
		String kinh = i.getStringExtra("kinh");
		int year = i.getIntExtra("year", 0);
		Bikini bikini = (Bikini) i.getSerializableExtra("bikini");
		
		Toast.makeText(this, "Nam "+year+", "+kinh+" len ngoi", 0).show();
		Toast.makeText(this, "Bikini "+bikini+" la so 1", 0).show();
	}

	@Override
	protected void onResume() {
		super.onResume();
		((EditText)findViewById(R.id.editText1)).setText("Hoang");
	}
	
	
	//----- EVENT ----//
	public void goFollower(View v){
		startActivity(new Intent(this, FollowerActivity.class));
	}
	
	public void goMain(View v){
		//pass name ->intent
		String name = ((EditText) findViewById(R.id.editText1)).getText().toString();
		Intent i = new Intent();
		i.putExtra("name", name);
		setResult(Constant.FROM_INFO_TO_MAIN, i);
		
		//close infor screen
		this.finish();
	}
	
	public void goEquip(View v){
		Intent goEquip = new Intent(InfoActivity.this,EquipActivity.class);
		startActivity(goEquip);
	}
	
}
