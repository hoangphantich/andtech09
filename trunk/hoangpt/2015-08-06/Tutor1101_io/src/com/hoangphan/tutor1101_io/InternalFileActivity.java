package com.hoangphan.tutor1101_io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class InternalFileActivity extends Activity {

	private EditText edtHello;
	private SeekBar skFontsize;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_external_file);
		
		edtHello = (EditText) findViewById(R.id.edtHello);
		skFontsize = (SeekBar) findViewById(R.id.skFontsize);
		
		//restore screen
		_readFile();

		//event
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
		//init output stream / writer (java.io)
		try {
			OutputStream out = openFileOutput("test.txt", MODE_PRIVATE);
			OutputStreamWriter writer = new OutputStreamWriter(out);
			
			//read text from editext
			String txtHello = edtHello.getText().toString();
			int fontSize = skFontsize.getProgress();
			
			//writer ->write into file
			writer.write(txtHello);
			writer.write("\n"+fontSize);
			writer.close();
		} catch (Exception e) {
			Toast.makeText(this, "Save not ok", 0).show();
			e.printStackTrace();
		}
		
		Toast.makeText(this, "Save ok", 0).show();
	}
	
	public void loadFile(View v){
		_readFile();
	}
	
	private void _readFile(){
		try {
			//vice versa
			FileInputStream in = openFileInput("test.txt");
			InputStreamReader reader = new InputStreamReader(in);
			BufferedReader bReader = new BufferedReader(reader);
			
			String txtHello = bReader.readLine();
			int fontSize = Integer.parseInt(bReader.readLine());
			
			edtHello.setText(txtHello);
			edtHello.setTextSize(fontSize);
			skFontsize.setProgress(fontSize);
			
			//close reader
			bReader.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
