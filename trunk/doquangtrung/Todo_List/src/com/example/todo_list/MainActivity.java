package com.example.todo_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends Activity implements OnClickListener {
	private Button btnAdd;
	private EditText edWork, edHour, edMinute;
	private ListView workList;
	ArrayList<String> list;
	ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void onResume(){
    	super.onResume();
    	_initUI();
    	btnAdd.setOnClickListener(this);
    }


    private void _initUI() {
    	btnAdd = (Button) findViewById(R.id.btnAdd);
        edWork = (EditText) findViewById(R.id.edWork);
        edHour = (EditText) findViewById(R.id.edHour);
        edMinute = (EditText) findViewById(R.id.edMinute);
        
        workList = (ListView) findViewById(R.id.listWork);
        list = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        workList.setAdapter(adapter);
		
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
	@Override
	public void onClick(View v) {
		String workName = edWork.getText().toString();
        String hourNr = edHour.getText().toString();
        String minuteNr = edMinute.getText().toString();
        
        if(workName.equals("") || hourNr.equals("") || minuteNr.equals("")){
                //display warning
                //Toast.makeText(this, "Wrong please input again", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Your workname or hour or minute is blank");
                builder.setPositiveButton("OK", null);
                builder.create().show(); //chaining
        } else {
                //add to list view
                list.add(hourNr+":"+minuteNr+" - "+workName);
                adapter.notifyDataSetChanged();
        }
        
        
        _resetUI();
		
	}
	private void _resetUI() {
		edWork.setText("");
        edHour.setText("");
        edMinute.setText("");
		
	}
}
