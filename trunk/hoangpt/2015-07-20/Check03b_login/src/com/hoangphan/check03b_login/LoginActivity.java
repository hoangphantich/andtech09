package com.hoangphan.check03b_login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private SixEditText edtName;
	private SixEditText edtPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		//ui
		_bindUI();
	}
	
	public void doLogin(View v){
		//validate
		if(_validate()){
			//authenticate
			if(_authen()){
				//go to another activity
				Toast.makeText(this, "Login OK", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "Login NOT OK", Toast.LENGTH_SHORT).show();
			};
		} else {
			Toast.makeText(this, "Must have 6 chars", 0).show();
		}
	}

	private boolean _validate() {
		if(edtName.validator() && edtPassword.validator()){
			return true;
		}
		return false;
	}

	private boolean _authen() {
		IAuthService service = new AuthStubService();
		
		String name = edtName.getText().toString();
		String password = edtPassword.getText().toString();
		boolean result = service.authenticate(name, password);
		
		return result;
	}

	private void _bindUI() {
		edtName = (SixEditText) findViewById(R.id.edtName);
		edtPassword = (SixEditText) findViewById(R.id.edtPassword);
	}
}
