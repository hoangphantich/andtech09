package com.example.multiplay_layout_demo;

import org.w3c.dom.Text;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Caculate extends Activity implements OnClickListener {
	private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, bnt8, btn9,
			btn0, btnCong, btnTru, btnNhan, btnChia, btnBang, btnClear;
	private EditText edNhap;
	private String a, b;
	private int kq, a1, b1, c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.caculate_layout);
		_add();
	}

	private void _add() {
		btn0 = (Button) findViewById(R.id.btn10);
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		btn5 = (Button) findViewById(R.id.btn5);
		btn6 = (Button) findViewById(R.id.btn6);
		btn7 = (Button) findViewById(R.id.btn7);
		btn8 = (Button) findViewById(R.id.btn8);
		btn9 = (Button) findViewById(R.id.btn9);
		btnCong = (Button) findViewById(R.id.btnCong);
		btnTru = (Button) findViewById(R.id.btnTru);
		btnNhan = (Button) findViewById(R.id.btnNhan);
		btnChia = (Button) findViewById(R.id.btnChia);
		btnBang = (Button) findViewById(R.id.btnBang);
		btnClear = (Button) findViewById(R.id.btnClear);
		
		edNhap = (EditText) findViewById(R.id.editText1);
		edNhap.setEnabled(false);
		
		btn0.setOnClickListener(this);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);
		btnCong.setOnClickListener(this);
		btnTru.setOnClickListener(this);
		btnNhan.setOnClickListener(this);
		btnChia.setOnClickListener(this);
		btnBang.setOnClickListener(this);
		btnClear.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		Button btn = (Button) v;
		int id = btn.getId();
		a = edNhap.getText().toString();
		if(id==R.id.btn1){
			edNhap.setText(a+"1");
		}
		else if(id==R.id.btn2){
			edNhap.setText(a+"2");
		}
		else if(id==R.id.btn3){
			edNhap.setText(a+"3");
		}
		else if(id==R.id.btn4){
			edNhap.setText(a+"4");
		}
		else if(id==R.id.btn5){
			edNhap.setText(a+"5");
		}
		else if(id==R.id.btn6){
			edNhap.setText(a+"6");
		}
		else if(id==R.id.btn7){
			edNhap.setText(a+"7");
		}
		else if(id==R.id.btn8){
			edNhap.setText(a+"8");
		}
		else if(id==R.id.btn9){
			edNhap.setText(a+"9");
		}
		else if(id==R.id.btn10){
			edNhap.setText(a+"0");
		}
		else if(id==R.id.btnCong){
			b = edNhap.getText().toString();
			edNhap.clearFocus();
			edNhap.setText("");
			c = 1;
		}
		else if(id==R.id.btnTru){
			b = edNhap.getText().toString();
			edNhap.clearFocus();
			edNhap.setText("");
			c = 2;
		}
		else if(id==R.id.btnChia){
			b = edNhap.getText().toString();
			edNhap.clearFocus();
			edNhap.setText("");
			c = 3;
		}
		else if(id==R.id.btnNhan){
			b = edNhap.getText().toString();
			edNhap.clearFocus();
			edNhap.setText("");
			c = 4;
		}
		else if(id==R.id.btnBang){
			edNhap.clearFocus();
			a1 = Integer.parseInt(a);
			b1 = Integer.parseInt(b);
			if(c==1){
				kq = a1+b1;
			}
			else if(c==2){
				kq = b1-a1;
			}
			else if(c==3){
				kq = (b1/a1);
			}
			else if(c==4){
				kq = a1*b1;
			}
			edNhap.setText(kq+"");
		}
		else if(id==R.id.btnClear){
			edNhap.clearFocus();
			edNhap.setText("");
		}
		
	}

}
