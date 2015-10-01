package com.hoangphan.helloandroidapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.*;

public class MyActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// create container
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);

		// create 1 textview
		final TextView txtWelcome = new TextView(this);
		txtWelcome.setText("Welcome to Android");

		// add to UI
		layout.addView(txtWelcome);

		// create 1 edittext
		final EditText edtName = new EditText(this);
		edtName.setWidth(600);
		edtName.setLines(1);
		edtName.setHint("Your name, please");

		// add to UI
		layout.addView(edtName);

		// set view = layout display
		setContentView(layout);

		// event for edittext
		//anonymous class
		edtName.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				Log.d("in", "Cai gi day");
				System.out.print("Go vao day roi nhe");

				// check press enter key
				if (keyCode == KeyEvent.KEYCODE_ENTER
						&& event.getAction() == KeyEvent.ACTION_DOWN) {
					// set text = input name
					String name = edtName.getText().toString();
					txtWelcome.setText("Hello " + name + " ^^");

					// reset = ""
					edtName.setText("");
				}

				return false;
			}
		});
	}
}
