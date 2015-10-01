package com.hoangphan.tutor0301_westernjourney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends Activity {

	/**
	 * EVENT FUNCTION
	 * 
	 * @param v
	 */
	public void testEquip(View v) {
		// start act (2 lines)
		Intent i = new Intent(MainActivity.this, EquipActivity.class);
		startActivity(i);

	}

	public void test(View v) {
		// start act
		Intent i = new Intent("di_tam_bien");
		startActivity(i);
	}

	public void goInfo(View v) {
		//pass parameter (data)
		Bundle bundle = new Bundle();
		bundle.putInt("year", 2015);
		bundle.putString("kinh", "kinh lao");
		bundle.putSerializable("bikini", new Bikini());
		
		// start act (2 lines)
		Intent i = new Intent(MainActivity.this, InfoActivity.class);
		i.putExtras(bundle); //put vali into intent
		startActivity(i);
	}
	
	public void goInfoWithDataBack(View v){
		Intent intent = new Intent(MainActivity.this, InfoActivity.class);
		startActivityForResult(intent, Constant.FROM_MAIN_TO_INFO);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if(requestCode == Constant.FROM_MAIN_TO_INFO){
			if(resultCode == Constant.FROM_INFO_TO_MAIN){
				String name = intent.getStringExtra("name");
				Toast.makeText(this, "Tao nhan ten may la "+name, 0).show();
			}
		}
	}

	/**
	 * VIEW RELATES
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.d("state", "Now is OnCreate");
	}

	@Override
	protected void onStart() {
		super.onStart();

		Log.d("state", "Now is onStart");
		ImageButton btnInfo = (ImageButton) findViewById(R.id.btnInfo);
		btnInfo.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// implement here
				goInfo(v);
			}
		});

	}

	@Override
	protected void onResume() {
		super.onResume();

		Log.d("state", "Now is onResume");

	}

	@Override
	protected void onPause() {
		super.onPause();

		Log.d("state", "Now is onPause");

	}

	@Override
	protected void onStop() {
		super.onStop();

		Log.d("state", "Now is onStop");

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		Log.d("state", "Now is onDestroy");
	}
}
