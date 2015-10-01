package com.hoangphan.tutor0903_asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class AsyncReponsiveActivity extends BaseActivity {

	private ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_threading_non_reponsive);
		img = (ImageView) findViewById(R.id.img);
	}
	
	public void loadImageSync(View v){
		new LoadImageTask().execute();
	}
	
	class LoadImageTask extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					Bitmap bm = BitmapFactory.decodeFile("/sdcard/Download/kute.jpg");
					img.setImageBitmap(bm); //chaining
				}
			});
			
			return null;
		}
	}
}
