package com.hoangphan.tutor0903_asynctask;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

public class BaseActivity extends Activity {

	public void toaster(View v){
		Toast.makeText(this, "Tao khong bi lanh cam", 1).show();;
	}
}