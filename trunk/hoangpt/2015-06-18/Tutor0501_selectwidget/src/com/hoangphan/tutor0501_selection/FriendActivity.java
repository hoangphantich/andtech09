package com.hoangphan.tutor0501_selection;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class FriendActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend);
	}
	
	public void changeUI(View v){
		setContentView(R.layout.flight);
	}
}
