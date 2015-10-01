package com.hoangphan.tutor1001_imdownloader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AsyncReponsiveFourImageQueueActivity extends BaseActivity {

	private ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_threading_non_reponsive);
		
		img = (ImageView) findViewById(R.id.img);
	}
	
	public void loadImageSync(View v){
		String[] urls = new String[]{
				"http://www.bhmpics.com/walls/designer_wallpaper-normal.jpg",
				"http://wallpaperswiki.org/wp-content/uploads/2012/11/Wallpaper-Flower-Abstract-Dark.jpg"
		};
		
		new LoadBigImageTask(this, img).execute(urls);
		
		
	}
}
