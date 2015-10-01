package com.hoangphan.tutor0301_westernjourney;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class EquipActivity extends Activity {

	@Override
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.equip_act);
	}
	
	
	public void goFollower(View v){
		startActivity(new Intent(this, FollowerActivity.class));
	}
}
