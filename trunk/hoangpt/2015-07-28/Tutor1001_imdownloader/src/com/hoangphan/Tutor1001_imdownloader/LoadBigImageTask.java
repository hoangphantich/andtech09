package com.hoangphan.tutor1001_imdownloader;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

public class LoadBigImageTask extends AsyncTask<String, Integer, Void>{
	
	Activity context;
	ImageView imageHolder;
	private Bitmap bm;
	
	class MyRunner implements Runnable{

		@Override
		public void run() {
			imageHolder.setImageBitmap(bm);
		}
	}

	public LoadBigImageTask(Activity context, ImageView imageHolder) {
		this.context = context;
		this.imageHolder = imageHolder;
	}

	@Override
	protected Void doInBackground(String... urls) {
		int count = 0;
		for (String url : urls) {
			//open connection
			try {
				URL urlObj = new URL(url);
				URLConnection conn = urlObj.openConnection();
				
				//inputstream
				InputStream is = conn.getInputStream();
				bm = BitmapFactory.decodeStream(is);
				
				context.runOnUiThread(new MyRunner());
				
				this.publishProgress(++count);
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		
	}

	@Override
	protected void onProgressUpdate(Integer... nrImages) {
		Toast.makeText(context, "Load "+nrImages[0]+" images", 1).show();
		
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}
	
}
