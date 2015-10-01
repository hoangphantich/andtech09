package com.example.west_journey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Src1Activity extends Activity {

	ImageButton btn_1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_src1);

		btn_1 = (ImageButton) this.findViewById(R.id.btn_1);

		btn_1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(
						"com.example.west_journey.Src2Activity");
				startActivityForResult(intent, 1);

			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1) {
			if (resultCode == 2) {
				Intent intent = data;
				Bundle bundel = data.getBundleExtra("bundle");
				String name = bundel.getString("name");
				String age = bundel.getString("age");
				Toast.makeText(getBaseContext(),
						"Name: " + name + " \n" + "Age: " + age,
						Toast.LENGTH_SHORT).show();
			} else if (resultCode == 11) {
				Intent intent = data;
				Bundle bundel = data.getBundleExtra("bundle");
				String name = bundel.getString("name");
				String age = bundel.getString("age");
				String sp1 = bundel.getString("sp1");
				String sp2 = bundel.getString("sp2");
				Toast.makeText(
						getBaseContext(),
						"Name: " + name + "\nAge: " + age + "\nWork for: "
								+ sp1 + "\nLive at: " + sp2, Toast.LENGTH_SHORT)
						.show();
			} else {
				Toast.makeText(getBaseContext(), "Khong co du lieu tra ve",
						Toast.LENGTH_SHORT).show();
			}
		}
	}

}
