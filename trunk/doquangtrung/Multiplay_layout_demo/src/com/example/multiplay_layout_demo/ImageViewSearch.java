package com.example.multiplay_layout_demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ImageViewSearch extends Activity implements OnClickListener {
	private Button btnSearch, btnSearchImages;
	private EditText edSearch;
	private String name;
	private WebView imageview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imagesearch_layout);
		edSearch = (EditText) findViewById(R.id.editText1);
		imageview = (WebView) findViewById(R.id.imageView1);
		btnSearch = (Button) findViewById(R.id.btnSearch);
		btnSearch.setOnClickListener(this);
		btnSearchImages = (Button) findViewById(R.id.btnSearchImage);
		btnSearchImages.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Button btn = (Button) v;
		int id = btn.getId();
		name = edSearch.getText().toString();
		if(id==R.id.btnSearch){
			imageview.loadUrl("http://www.google.com.vn/search?q="+name);
		}
		else if(id==R.id.btnSearchImage){
			imageview.loadUrl("https://www.google.com.vn/search?site=&tbm=isch&source=hp&biw=1366&bih=675&q="+name+"&oq="+name+"&gs_l");
		}
	}
}
