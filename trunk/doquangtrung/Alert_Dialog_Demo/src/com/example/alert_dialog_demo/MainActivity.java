package com.example.alert_dialog_demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btnLogin;
	private EditText edEmail, edPass;
	private String a, b, c, d;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edEmail = (EditText) findViewById(R.id.edEmail);
		edPass = (EditText) findViewById(R.id.edPass);
		c = "trung";
		d = "1234";
		_login();

	}

	private void _ald() {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle("Warning");
		alertDialog.setMessage("Please try again!");
		alertDialog.setIcon(R.drawable.iconx);
		alertDialog.setPositiveButton("OK", null);
		alertDialog.show();
	}

	private void _login() {
		btnLogin = (Button) findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				_checked();
			}

		});
	}

	private void _checked() {
		a = edEmail.getText().toString();
		b = edPass.getText().toString();
		if (a.equals(c) && b.equals(d)) {
			Toast.makeText(this, "Login success!", Toast.LENGTH_LONG).show();
		} else{
			_ald();
		}
	}
}
