package com.hoangphan.tutor0901_thread;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class ThreadingReponsiveActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_threading_non_reponsive);
	}
	
	public void loadImageSync(View v){
		//init threading
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				//run thread in 5s
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				//after 5s -> load image
				Log.d("ANR", "Khong bi ANR");

				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						Bitmap bm = BitmapFactory.decodeFile("/sdcard/Download/kute.jpg");
						((ImageView) findViewById(R.id.img)).setImageBitmap(bm); //chaining
					}
				});
			}
		}).start();
	}
	
}
