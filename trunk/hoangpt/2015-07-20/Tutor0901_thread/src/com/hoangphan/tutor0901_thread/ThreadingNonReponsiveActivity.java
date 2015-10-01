package com.hoangphan.tutor0901_thread;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ThreadingNonReponsiveActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_threading_non_reponsive);
	}
	
	
	public void loadImageSync(View v){
		//simulate load 5s
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//load image from /sdcard
		Bitmap bm = BitmapFactory.decodeFile("/sdcard/Download/kute.jpg");
		((ImageView) findViewById(R.id.img)).setImageBitmap(bm); //chaining
	}
}
