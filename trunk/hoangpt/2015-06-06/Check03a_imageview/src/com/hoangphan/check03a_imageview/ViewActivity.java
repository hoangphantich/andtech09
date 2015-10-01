package com.hoangphan.check03a_imageview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class ViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		
		//get data from intent
		String path = getIntent().getStringExtra("path");
		
		//build bitmap from real image
		Bitmap bm = BitmapFactory.decodeFile("/sdcard/Download/dog/"+path+".gif");
		
		//display
		ImageView imgDog = (ImageView) findViewById(R.id.imgDog);
		imgDog.setImageBitmap(bm);
	}
}
