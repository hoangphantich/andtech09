package com.example.west_journey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Src2Activity extends Activity {

	EditText edt_name;
	EditText edt_age;
	Button btn_go_main_2;
	Button btn_go3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_src2);

		edt_name = (EditText) this.findViewById(R.id.edt_name);
		edt_age = (EditText) this.findViewById(R.id.edt_age);
		btn_go_main_2 = (Button) this.findViewById(R.id.btn_go_main_2);
		btn_go3 = (Button) this.findViewById(R.id.btn_go3);

		btn_go_main_2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bundle bundle = new Bundle();
				bundle.putString("name", edt_name.getText().toString());
				bundle.putString("age", edt_age.getText().toString());

				Intent back = new Intent();
				back.putExtra("bundle", bundle);

				int back1 = 2;
				if (edt_name.getText().toString().equals("")
						|| edt_age.getText().toString().equals(""))
					back1 = 0;
				setResult(back1, back);
				finish();
			}

		});
		btn_go3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(
						"com.example.west_journey.Src3Activity");
				startActivityForResult(intent, 2);

			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (data != null) {
			if (requestCode == 2) {

				Bundle bundle = new Bundle();
				bundle.putString("name", edt_name.getText().toString());
				bundle.putString("age", edt_age.getText().toString());

				bundle.putString("sp1", data.getStringExtra("txt_spin1"));
				bundle.putString("sp2", data.getStringExtra("txt_spin2"));

				Intent back = new Intent();
				back.putExtra("bundle", bundle);
				setResult(11, back);

				this.finish();
			}
		}
	}
}
