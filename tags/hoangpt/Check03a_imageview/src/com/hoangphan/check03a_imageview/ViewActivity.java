package com.hoangphan.check03a_imageview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class ViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		
		//get data from intent
		String path = getIntent().getStringExtra("path");
		
		//build bitmap from real path
		Bitmap bm = BitmapFactory.decodeFile("/sdcard/Download/girl/"+path+".jpg");
		
		//display
		ImageView imgDog = (ImageView) findViewById(R.id.imgDog);
		imgDog.setImageBitmap(bm);
	}
}
