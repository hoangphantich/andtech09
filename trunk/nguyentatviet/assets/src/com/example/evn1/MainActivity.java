package com.example.evn1;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText editquantity, editheso;
	Button btnNhap;
	RadioGroup radgroup;
	ListView lvNhanvien;
	TextView txttotal, txtvat, txttongtien;
	ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editquantity = (EditText) findViewById(R.id.editquantity);
		editheso = (EditText) findViewById(R.id.editHeso);
		btnNhap = (Button) findViewById(R.id.btnnhap);
		lvNhanvien = (ListView) findViewById(R.id.lvnhanvien);
		txttotal = (TextView) findViewById(R.id.txttotal);
		txtvat = (TextView) findViewById(R.id.txtvat);
		txttongtien = (TextView) findViewById(R.id.txttongtien);

		btnNhap.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				processNhap();
			}
		});
	}

	public void processNhap() {
		int quantity = Integer.parseInt(editquantity.getText().toString());
		if (quantity < 100) {
			arrEmployee.add(new Employee(quantity, 1000));
		} else if (quantity < 150) {
			arrEmployee.add(new Employee(100, 1000));
			arrEmployee.add(new Employee(quantity - 100, 1500));
		} else if (quantity < 200) {
			arrEmployee.add(new Employee(100, 1000));
			arrEmployee.add(new Employee(50, 1500));
			arrEmployee.add(new Employee(quantity - 150, 2000));
		} else {
			arrEmployee.add(new Employee(100, 1000));
			arrEmployee.add(new Employee(50, 1500));
			arrEmployee.add(new Employee(50, 2000));
			arrEmployee.add(new Employee(100, 2500));
			arrEmployee.add(new Employee(quantity - 400, 3500));
		}
		double Total = 0;
		// đưa Data Source là các employee vào Adapter
		if (arrEmployee != null && arrEmployee.size() > 0) {
			for (Employee employee : arrEmployee) {
				Total += employee.getQuantity() * employee.getHeso();
			}
		} else {
			System.out.println("bat thuong");
		}
		ArrayAdapter<Employee> adapter = new ArrayAdapter<Employee>(this,
				android.R.layout.simple_list_item_1, arrEmployee);
		// đưa adapter vào ListView
		lvNhanvien.setAdapter(adapter);

	}
}
