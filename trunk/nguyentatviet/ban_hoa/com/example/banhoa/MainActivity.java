package com.example.banhoa;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void btntiep(View v) {
		Flower flower = new Flower();
		ListFlower list = new ListFlower();
		EditText edita = (EditText) findViewById(R.id.btntinhtt);
		String a = edita.getText() + "";
		TextView txtflower = (TextView) findViewById(R.id.textView2);
		if (a == "") {
			Toast toast = Toast.makeText(this, "Nhap hoa vao!",
					Toast.LENGTH_SHORT);
			toast.show();
		} else {
			flower.setTenhoa(edita.getText() + "");
			list.addKhachHang(flower);
			txtflower.setText(flower.getTenhoa() + "");
			edita.setText("");
			edita.requestFocus();
		}

	}
	public void btnthongke(View v){
		TextView txtflower = (TextView) findViewById(R.id.textView2);
		ListFlower list = new ListFlower();
		txtflower.setText(list.tongFlower() + "");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
