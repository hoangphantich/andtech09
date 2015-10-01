package com.hoangphan.tutor0901_thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class ThreadingDogAnimationActivity extends BaseActivity {

	private ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_threading_non_reponsive);
		
		img = (ImageView) findViewById(R.id.img);
	}
	
	public void loadImageSync(View v){
		//init threading
		new Thread(new Runnable() {
			
			int count = 0;
			@Override
			public void run() {
				//run thread in 5s
				while (true) {
					count = count%14;
					
					runOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							Bitmap bm = BitmapFactory.decodeFile("/sdcard/Download/dog/T"+count+".gif");
							img.setImageBitmap(bm); //chaining
						}
					});
					count++; //T1
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
