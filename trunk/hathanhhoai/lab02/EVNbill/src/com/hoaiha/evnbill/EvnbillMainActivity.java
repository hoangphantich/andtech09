package com.hoaiha.evnbill;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EvnbillMainActivity extends Activity implements OnClickListener {
	private Button caculate, print;
	private EditText name, quantity;
	private TextView totalfee, vat, totalvat, number1, number2, price1, price2,
			total1, total2;
	int a = 0,b = 0,d=1000,e=1500,f,g;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.evnbill_main);		
		findView();
	}

	private void findView() {
		caculate = (Button) findViewById(R.id.caculatebtn);
		print = (Button) findViewById(R.id.printbtn);
		
		caculate.setOnClickListener(this);
		print.setOnClickListener(this);
		
		name = (EditText) findViewById(R.id.nameedt);
		quantity = (EditText) findViewById(R.id.edtquantity);
		total1 = (TextView) findViewById(R.id.total1tv);
		total2 = (TextView) findViewById(R.id.total2tv);
		number1 = (TextView) findViewById(R.id.number1tv);
		number2 = (TextView) findViewById(R.id.number2tv);
		price1 = (TextView) findViewById(R.id.price1tv);
		price2 = (TextView) findViewById(R.id.price2tv);
		totalfee = (TextView) findViewById(R.id.totalfeetv);
		totalvat = (TextView) findViewById(R.id.totalvattv);
		vat = (TextView) findViewById(R.id.vattv);
	}

	@Override
	public void onClick(View v) {
		Log.d("d0", "Vao day chua");
		switch (v.getId()) {
		case R.id.caculatebtn:
			quantity.getText().toString();
			int c = Integer.parseInt(quantity.getText().toString());
			//int a = 0,b = 0,d=1000,e=1500,f,g;
			//in so dien
			if(c>100){
				a=100; b = c-a;
				number1.setText(" "+a);
				number2.setText(" "+b);
			} else {
				number1.setText(" " +c);
				//f=c*d; g = c*e;
			}
			//in gia tien
			price1.setText(" " + d);
			price2.setText(" " + e);
			f=a*d; g = b*e;;
			total1.setText(" "+ f);
			total2.setText(" " +g);
			totalfee.setText(" "+ (f+g));
			vat.setText(""+(f+g)/10);
			totalvat.setText(""+((f+g)+((f+g)/10)));
			break;
		case R.id.printbtn:
			name.getText().toString();
			
			showThongBao();
			break;
		}
	}
	public void showThongBao(){
		AlertDialog.Builder thongbao=new AlertDialog.Builder(EvnbillMainActivity.this);
		thongbao.setTitle("hoìa ðõn tiêÌn ðiêòn cuÒa anh(chiò) " + name.getText().toString() +" laÌ :");
		//thongbao.setIcon(getWallpaper());
		thongbao.setMessage("TiêÌn ðiêòn thaìng naÌy laÌ : " +((f+g)+((f+g)/10)) + " VND ");
		thongbao.setPositiveButton("Yes", new DialogInterface. OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
				
			}});
		thongbao.setNegativeButton("No", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}});
		thongbao.create().show();		
	}
}
