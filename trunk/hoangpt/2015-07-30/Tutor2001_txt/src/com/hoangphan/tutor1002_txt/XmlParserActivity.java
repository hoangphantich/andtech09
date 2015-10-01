package com.hoangphan.tutor1002_txt;

import java.io.InputStream;

import org.json.JSONException;
import org.json.JSONObject;

import com.hoangphan.tutor1002_txt.utils.Network;
import com.hoangphan.tutor1002_txt.utils.TextFactory;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class XmlParserActivity extends Activity {
	
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
		
		String url = "http://demos.9xkun.com/test.json";
		new JsonAsyncTask().execute(url);
	}
	
	class JsonAsyncTask extends AsyncTask<String, Void, Void>{

		private String name;

		@Override
		protected Void doInBackground(String... urls) {
			InputStream is = Network.getIsFromUrl(urls[0]);
			String fileText = TextFactory.decode(is);
			
			Log.d("txt", fileText);
			try {
				JSONObject userJSON = new JSONObject(fileText);
				JSONObject hoangJSON = userJSON.getJSONObject("user");
				name = hoangJSON.getString("name");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			edtName.setText(name);
			edtAge.setText("so 2 chu khong 2");
			edtJob.setText("hehehe");
		}		
	}
}
