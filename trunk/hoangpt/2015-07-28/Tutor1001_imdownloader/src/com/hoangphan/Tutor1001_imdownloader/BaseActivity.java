package com.hoangphan.tutor1001_imdownloader;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class BaseActivity extends Activity {
	
	public void toaster(View v){
		Toast.makeText(this, "Tao khong bi lanh cam", 1).show();;
	}
}
