package com.hoangphan.tutor1101_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

@SuppressWarnings("resource")
public class PreferenceFileActivity extends Activity {

	private EditText edtHello;
	private SeekBar skFontsize;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_external_file);
		
		edtHello = (EditText) findViewById(R.id.edtHello);
		skFontsize = (SeekBar) findViewById(R.id.skFontsize);
		skFontsize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				edtHello.setTextSize(progress);
			}
		});
	}
	
	/*********
	* EVENT WRITE HERE (WIREFRAME)
	*********/
	public void saveFile(View v){	
		SharedPreferences settings = getSharedPreferences("my_preferred_choices",
				Context.MODE_PRIVATE); //xml
		
		SharedPreferences.Editor editor = settings.edit(); 
		editor.putString("hello_txt", edtHello.getText().toString()); 
		editor.putInt("font_size", skFontsize.getProgress());
		editor.commit();
		Toast.makeText(this, "Save ok", 0).show();
	}
	
	public void loadFile(View v){
		SharedPreferences settings = getSharedPreferences("my_preferred_choices",
				Context.MODE_PRIVATE); //xml
		
		String helloTxt = settings.getString("hello_txt", "default blank"); 
		int fontSize = settings.getInt("font_size", 0);

		edtHello.setText(helloTxt);
		edtHello.setTextSize(fontSize);
		skFontsize.setProgress(fontSize);
	}
}
