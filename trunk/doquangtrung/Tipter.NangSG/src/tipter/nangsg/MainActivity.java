package tipter.nangsg;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener {
	private EditText edQuantity, money, edVat;
	private Button btnCong, btnTru, btnTotal;;
	int qtang = 0;
	int m_type = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edQuantity = (EditText) findViewById(R.id.editText1);
		btnCong = (Button) findViewById(R.id.button2);
		btnTru = (Button) findViewById(R.id.button1);
		edVat = (EditText) findViewById(R.id.editText2);
		money = (EditText) findViewById(R.id.editText3);
		btnTotal = (Button) findViewById(R.id.button3);
		edVat.setText("10%");
		btnCong.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				qtang = qtang + 1;
				edQuantity.setText(String.valueOf(qtang));
			}
		});
		btnTru.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (qtang > 0) {
					qtang = qtang - 1;
					edQuantity.setText(String.valueOf(qtang));
				} else {
					edQuantity.destroyDrawingCache();
				}

			}
		});
		btnTotal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				money.setText((Integer.parseInt(edQuantity.getText().toString()) * m_type * 11)/10 + "VND");
			}
		});

		Spinner spinner = (Spinner) findViewById(R.id.spinner1);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.drinks_array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		TextView myText = (TextView) view;
		Toast.makeText(this, "Do uong da chon: " + myText.getText(),
				Toast.LENGTH_LONG).show();
		float tmp = 0;
		switch(position) {
		case 0: 
			m_type = 8000;
			break;
		case 1: 
			m_type = 10000;
			break;
		case 2: 
			m_type = 45000;
			break;
		case 3: 
			m_type = 10000;
			break;
		case 4: 
			m_type = 10000;
			break;
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

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
