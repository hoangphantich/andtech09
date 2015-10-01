package com.hoangphan.tutor1001_imdownloader;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
	Bitmap bm;

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
			String url = "http://www.bhmpics.com/walls/designer_wallpaper-normal.jpg";
			
			//open connection
			try {
				URL urlObj = new URL(url);
				URLConnection conn = urlObj.openConnection();
				
				//inputstream
				InputStream is = conn.getInputStream();
				bm = BitmapFactory.decodeStream(is);
				img.setImageBitmap(bm); //chaining
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
	}
}
