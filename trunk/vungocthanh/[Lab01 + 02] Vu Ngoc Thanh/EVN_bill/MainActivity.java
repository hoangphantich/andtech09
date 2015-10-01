package com.example.evn_bill;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText edt_name;
	EditText edt_quantity;
	Button btn_calculate;
	TextView txt1a;
	TextView txt1b;
	TextView txt1c;
	TextView txt2a;
	TextView txt2b;
	TextView txt2c;
	TextView txt_total_fee;
	TextView txt_vat;
	TextView txt_total;
	Button btn_print;
	ProgressDialog dialog;
	int run = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		edt_name = (EditText) this.findViewById(R.id.edt_name);
		edt_quantity = (EditText) this.findViewById(R.id.edt_quantity);
		btn_calculate = (Button) this.findViewById(R.id.btn_calculate);
		txt1a = (TextView) this.findViewById(R.id.txt1a);
		txt1b = (TextView) this.findViewById(R.id.txt1b);
		txt1c = (TextView) this.findViewById(R.id.txt1c);
		txt2a = (TextView) this.findViewById(R.id.txt2a);
		txt2b = (TextView) this.findViewById(R.id.txt2b);
		txt2c = (TextView) this.findViewById(R.id.txt2c);
		txt_total_fee = (TextView) this.findViewById(R.id.txt_total_fee);
		txt_vat = (TextView) this.findViewById(R.id.txt_vat);
		txt_total = (TextView) this.findViewById(R.id.txt_total);
		btn_print = (Button) this.findViewById(R.id.btn_print);

		// Button calculate

		btn_calculate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String str2;
				edt_name.getText().toString();
				str2 = edt_quantity.getText().toString();
				int str3 = Integer.parseInt(str2);

				if (str3 > 0 && str3 < 101) {
					txt1a.setText(String.valueOf(str3));
					txt1b.setText(String.valueOf(1000));
					txt1c.setText(String.valueOf((int) (str3 * 1000)));

					txt2a.setVisibility(View.INVISIBLE);
					txt2b.setVisibility(View.INVISIBLE);
					txt2c.setVisibility(View.INVISIBLE);

					txt_total_fee.setText(String.valueOf((int) (str3 * 1000)));
					txt_vat.setText("  "
							+ String.valueOf((int) (str3 * 1000 * 0.1)));
					txt_total.setText(String.valueOf((int) (str3 * 1000 * 1.1)));

				} else if (str3 > 100) {
					txt2a.setVisibility(View.VISIBLE);
					txt2b.setVisibility(View.VISIBLE);
					txt2c.setVisibility(View.VISIBLE);

					txt1a.setText(String.valueOf(100));
					txt1b.setText(String.valueOf(1000));
					txt1c.setText(String.valueOf((int) 100 * 1000));
					txt2a.setText(String.valueOf((int) (str3 - 100)));
					txt2b.setText(String.valueOf(1500));
					txt2c.setText(String.valueOf((int) ((str3 - 100) * 1500)));

					txt_total_fee.setText(String
							.valueOf((int) (str3 * 1500 - 500 * 100)));
					txt_vat.setText("  "
							+ String.valueOf((int) ((str3 * 1500 - 500 * 100) * 0.1)));
					txt_total.setText(String
							.valueOf((int) ((str3 * 1500 - 500 * 100) * 1.1)));

				}

			}
		});

		// Button print

		btn_print.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				run = 0;
				dialog = new ProgressDialog(MainActivity.this);
				dialog.setTitle("Printing");
				dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				dialog.setProgress(0);
				dialog.setMax(50);
				
				
				dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						
					}
				});
				dialog.show();
				new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							while (dialog.getProgress() <= dialog.getMax()) {
								Thread.sleep(1000);
								dialog.setProgress(run = run + 5);
								
								
							}
						} catch (Exception e) {
						}
						;
					}
				}).start();
			}
		});

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
