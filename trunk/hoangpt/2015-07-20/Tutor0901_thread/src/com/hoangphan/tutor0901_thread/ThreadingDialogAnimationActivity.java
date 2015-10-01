package com.hoangphan.tutor0901_thread;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class ThreadingDialogAnimationActivity extends BaseActivity {

	private ImageView img;
	private ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_threading_non_reponsive);
		
		img = (ImageView) findViewById(R.id.img);
		
	}
	
	public void loadImageSync(View v){
		dialog = new ProgressDialog(
				ThreadingDialogAnimationActivity.this);
		dialog.setMessage("Its loading....");
		dialog.setTitle("ProgressDialog bar example");
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		
		
		//display dialog
		dialog.show();
		Log.d("debug", "Vao day chua");
		
		//init threading
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				//run thread in 5s
				for (int i = 0; i < 5; i++) {
					dialog.incrementProgressBy(20);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				dialog.dismiss();				
				
				//after 5s -> load image
				Log.d("ANR", "Khong bi ANR");

				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						Bitmap bm = BitmapFactory.decodeFile("/sdcard/Download/kute.jpg");
						img.setImageBitmap(bm); //chaining
					}
				});
			}
		}).start();
	}
}
