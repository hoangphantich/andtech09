package westjourney.com;

import java.util.ArrayList;
import java.util.List;



import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class ThirdActivity extends Activity {
	private Spinner spnWeapon;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		
		//get intent, get bundle
		String name = getIntent().getStringExtra("name");
		Toast.makeText(ThirdActivity.this, "name:"+name, Toast.LENGTH_SHORT).show();
	
		//initUI
		initUI();
	}
	private void initUI() {
		spnWeapon = (Spinner) findViewById(R.id.spnWeapon);
		
		final List<String> list = new ArrayList<String>();
		list.add("Quyen truong");
		list.add("Con");
		list.add("Gay danh ma");
		
		//generic list->data_input
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnWeapon.setAdapter(dataAdapter);
		spnWeapon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				String str = list.get(position);
				Toast.makeText(getApplicationContext(), 
						"You have selected "+str, Toast.LENGTH_LONG).show();
;			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		
		
		});
		
	}
	
	public void goMain(View v){
		startActivityForResult(
				new Intent(ThirdActivity.this, FirstActivity.class ), 
				Constant.REQUEST_FROM3TO1);
	}
	public void goAccompany(View v){
		startActivity(
				new Intent(ThirdActivity.this, FourActivity.class )); 
				
	}
	
}
