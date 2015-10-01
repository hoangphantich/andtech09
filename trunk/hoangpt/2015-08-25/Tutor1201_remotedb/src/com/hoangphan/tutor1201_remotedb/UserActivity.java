package com.hoangphan.tutor1201_remotedb;

import java.io.Serializable;

import com.hoangphan.tutor1201_remotedb.model.User;
import com.hoangphan.tutor1201_remotedb.model.UserManager;

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
		_bindView();

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
	}
}
