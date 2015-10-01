package com.example.load_image;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Image extends Activity {
	
	ImageView img;
	TextView txt_image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		
		img = (ImageView) this.findViewById(R.id.img);
		txt_image = (TextView) this.findViewById(R.id.txt_image);
		
		Intent intent = getIntent();
		String image = "Your picture: " + intent.getStringExtra("str");
		txt_image.setText(image);
		loadDataFromAsset();
		
	}
	 public void loadDataFromAsset() {
		 
	        // load image
	        try {
	            // get input stream
	            InputStream ims = getAssets().open("f15022208.jpg");
	            // load image as Drawable
	            Drawable d = Drawable.createFromStream(ims, null);
	            // set image to ImageView
	            img.setImageDrawable(d);
	        }
	        catch(IOException ex) {
	            return;
	        }
	 
	    }
}
