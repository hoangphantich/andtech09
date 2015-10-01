package com.hoangphan.tutor1102_nativesql;

import java.io.Serializable;

import com.hoangphan.tutor1102_nativesql.model.User;
import com.hoangphan.tutor1102_nativesql.model.UserManager;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class UserActivity extends Activity {

	private EditText edtName;
	private EditText edtAge;
	private Spinner spnNation;
	private int id;
	private UserManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user);
		
//		Serializable o = getIntent().getSerializableExtra("user");
//		User u = (User) o;
//		Log.d("user", u.id+","+u.name);
		
		SQLiteDatabase db = openOrCreateDatabase("myfriendadv.sqlite3", MODE_PRIVATE, null);
		manager = new UserManager(db);
		id = getIntent().getIntExtra("id", 0);
		User user = manager.findUser(id);
		
		_bindView();
		_dataBinding(user);	
		
		Log.d("user", user.id+","+user.name);
	}

	private void _bindView() {
		edtName = (EditText) findViewById(R.id.edtName);
		edtAge = (EditText) findViewById(R.id.edtAge);
		spnNation = (Spinner) findViewById(R.id.spnNationalities);
		
	}

	private void _dataBinding(User u) {
		edtName.setText(u.name);
		edtAge.setText(u.age+"");
		spnNation.setSelection(u.nationId);
	}
	
	public void updatePerson(View v){
		String name = edtName.getText().toString();
		int age = Integer.parseInt(edtAge.getText().toString());
		int nationId = spnNation.getSelectedItemPosition();
		
		User u2 = new User(id, name, age, nationId);
		manager.updateUser(u2);
		
		startActivity(new Intent(this, SQLAdvanceTwoActivity.class));
		finish();
	}
}
