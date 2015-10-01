package com.example.ext_task;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	Button btn_add;
	Button btn_delete;
	Button btn_save;
	EditText edt_input;
	EditText edt_hour;
	EditText edt_minute;
	EditText edt_second;
	ListView list;
	ArrayList<Information> myArray;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edt_input = (EditText) this.findViewById(R.id.edt_input);
		edt_hour = (EditText) this.findViewById(R.id.edt_hour);
		edt_minute = (EditText) this.findViewById(R.id.edt_minute);
		edt_second = (EditText) this.findViewById(R.id.edt_second);
		btn_add = (Button) this.findViewById(R.id.btn_add);
		btn_delete = (Button) this.findViewById(R.id.btn_delete);
		btn_save = (Button) this.findViewById(R.id.btn_save);
		
		list = (ListView) this.findViewById(R.id.listView1);
		myArray = new ArrayList<Information>();
		
		final MyAdapter adapter = new MyAdapter(this, R.layout.item, myArray);
		
		list.setAdapter(adapter);
		
		
		// Button add
		btn_add.setOnClickListener(new OnClickListener() {
			

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				add();
		}
		
		public void add() {
			String input = edt_input.getText().toString();
			int hour = Integer.parseInt(edt_hour.getText().toString());
			int minute = Integer.parseInt(edt_minute.getText().toString());
			int second = Integer.parseInt(edt_second.getText().toString());
			Information inf = new Information();
			inf.setWork(input);
			inf.setHour(hour);
			inf.setMinute(minute);
			inf.setSecond(second);
			myArray.add(inf);
			adapter.notifyDataSetChanged();
			edt_input.setText("") ;
			edt_hour.setText("") ;
			edt_minute.setText("") ;
			edt_second.setText("") ;
			
		}
		
		// Button delete
	});
		btn_delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				delete();
			}
			
			public void delete() {
				for ( int i = list.getChildCount() - 1 ; i >= 0 ; i --) {
					View v = list.getChildAt(i);
					CheckBox check = (CheckBox) v.findViewById(R.id.checkBox);
					if(check.isChecked()) {
						myArray.remove(i);
					}
				}
				adapter.notifyDataSetChanged();
			}
		});
		
		// Button save
		btn_save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				saveToFile();
				// khai bao list object
				ListInfo listInf = new ListInfo();
				listInf.setMyArray(myArray);
				
				// cho vao bundle
				Bundle bundle = new Bundle();				
				bundle.putSerializable("list", listInf);
				
				
				// cho bundle lai vao intent
				Intent intent = new Intent("com.example.ext_task.ShowActivity");
				intent.putExtra("bundle", bundle);
				startActivity(intent);
			}
			public void saveToFile () {
				try {
				    FileOutputStream fos = new FileOutputStream("task.txt");
				    ObjectOutputStream oos = new ObjectOutputStream(fos);   
				    oos.writeObject(myArray); // write MenuArray to ObjectOutputStream
				    oos.close(); 
				} catch(Exception ex) {
				    ex.printStackTrace();
				}
			}
			
		});
}
}
