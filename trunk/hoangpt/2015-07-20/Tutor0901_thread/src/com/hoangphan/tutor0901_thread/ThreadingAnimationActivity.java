package com.hoangphan.tutor0901_thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class ThreadingAnimationActivity extends BaseActivity {

	private ProgressBar pgr;
	private ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_threading_non_reponsive);
		
		pgr = (ProgressBar) findViewById(R.id.pgr);
		img = (ImageView) findViewById(R.id.img);
	}
	
	public void loadImageSync(View v){
		//init threading
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				//display progress
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						pgr.setVisibility(View.VISIBLE);
						img.setVisibility(View.INVISIBLE);
					}
				});
				
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
						pgr.setVisibility(View.GONE);
						img.setVisibility(View.VISIBLE);
						
						Bitmap bm = BitmapFactory.decodeFile("/sdcard/Download/kute.jpg");
						img.setImageBitmap(bm); //chaining
					}
				});
			}
		}).start();
	}
}
