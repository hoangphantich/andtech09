package com.example.flower_sell;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("SimpleDateFormat")
public class MainActivity extends Activity {

	public EditText input;
	public Button buy, check;
	public ListView list;
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		input = (EditText) this.findViewById(R.id.hoa);
		buy = (Button) this.findViewById(R.id.buy);
		check = (Button) this.findViewById(R.id.checkout);
		list = (ListView) this.findViewById(R.id.list);
		
		
		final ArrayList<String> arr = new ArrayList<String>();

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, arr);

		list.setAdapter(adapter);

		buy.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!input.getText().toString().equals("") ){
					String str = input.getText().toString()
							+ " add to order sucessfully, I will contact with you sooner <3";
					Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT)
							.show();

					arr.add(input.getText().toString());
					adapter.notifyDataSetChanged(); // cap nhat lai adapter
					input.setText("");
					
				}
				
			}
		});
		
		check.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss");
				String time = sdf.format(new Date());
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		        //Thiết lập tiêu đề hiển thị
		        builder.setTitle("Receipt for flower");
		        //Thiết lập thông báo hiển thị
		        builder.setMessage("Thank you for your order of my flowers \nMoney you must pay is: " + arr.size()*1000 + "$\nI have a receided at: \n" + time );
		        builder.setCancelable(false);
		        //Tạo nút Activity2
		        builder.setPositiveButton("OK",
		                new DialogInterface.OnClickListener() {
		                    public void onClick(DialogInterface dialog,
		                            int which) {
		                      
		                    }
		                });
		       builder.create().show();
			}
		});
	}

}
