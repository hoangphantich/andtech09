package com.hoangphan.tutor1002_txt;

import java.io.InputStream;

import com.hoangphan.tutor1002_txt.utils.Network;
import com.hoangphan.tutor1002_txt.utils.TextFactory;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class TextParserActivity extends Activity {

	private EditText edtName;
	private EditText edtAge;
	private EditText edtJob;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_parser);
		
		edtName = (EditText) findViewById(R.id.edtName);
		edtAge = (EditText) findViewById(R.id.edtAge);
		edtJob = (EditText) findViewById(R.id.edtJob);
		
		String url = "http://demos.9xkun.com/test.txt";
		new TextAsyncTask().execute(url);
	}
	
	class TextAsyncTask extends AsyncTask<String, Void, Void>{

		String[] infos;
		
		@Override
		protected Void doInBackground(String... urls) {
			InputStream is = Network.getIsFromUrl(urls[0]);
			String fileText = TextFactory.decode(is);
			
			Log.d("txt", fileText);
			
			infos = fileText.split(",");
			
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			edtName.setText(infos[0]);
			edtAge.setText(infos[1]);
			edtJob.setText(infos[2]);
		}
	}
}
