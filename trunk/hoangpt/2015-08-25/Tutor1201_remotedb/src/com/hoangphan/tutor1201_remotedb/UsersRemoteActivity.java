package com.hoangphan.tutor1201_remotedb;

import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.hoangphan.tutor1201_remotedb.helper.Network;
import com.hoangphan.tutor1201_remotedb.helper.TextFactory;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class UsersRemoteActivity extends Activity {

	private ListView lstPeople;
	private ArrayAdapter<Object> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_users_remote);
		
		_bindView();
		String url = "http://192.168.57.1/_MOBILE.WS/users/list_users.php";
		new UserJsonAsyncTask().execute(url);
	}
	
	private void _bindView() {
		lstPeople = (ListView) findViewById(R.id.lstPeople);
		adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
		lstPeople.setAdapter(adapter);
	}
	
	class UserJsonAsyncTask extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... params) {
			String url = params[0];
			InputStream is = Network.getIsFromUrl(url);
			String json = TextFactory.decode(is);
			
			return json;
		}

		@Override
		protected void onPostExecute(String result) {
			//parser json
			ArrayList<String> userList = new ArrayList<>();
			try {
				JSONArray users = new JSONArray(result);
				for (int i = 0; i < users.length(); i++) {
					JSONObject user = (JSONObject) users.get(i);
					String name = user.getString("name");
					
					userList.add(name);
				}
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			adapter.addAll(userList);
			adapter.notifyDataSetChanged();
		}
	}
}
