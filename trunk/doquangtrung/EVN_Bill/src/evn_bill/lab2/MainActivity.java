package evn_bill.lab2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText edQuantity, edName;
	Button btnCaculate;
	TextView total1, totalfee, Vat;
	int total, totalt, vat;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edQuantity = (EditText) findViewById(R.id.edQuantity);
		btnCaculate = (Button) findViewById(R.id.btnCaculate);
		totalfee = (TextView) findViewById(R.id.txtTo1);
		total1 = (TextView) findViewById(R.id.txtTotalfee);
		Vat = (TextView) findViewById(R.id.txtvat1);
		btnCaculate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				tinh();
				Vat.setText(vat + " ");
				total1.setText(total + " ");
				totalfee.setText(totalt + " ");

			}
		});
	}

	public void tinh() {
		int quantity, x1 = 0, x2 = 0, x3 = 0;
		quantity = Integer.parseInt(edQuantity.getText().toString());
		if (quantity <= 100) {
			x1 = quantity;
			x2 = 0;
			x3 = 0;
		} else if (quantity > 100 && quantity < 200) {
			x1 = 100;
			x2 = quantity - 100;
			x3 = 0;
		} else if (quantity > 200) {
			x1 = 100;
			x2 = quantity - 100;
			x3 = quantity - 200;
		}
		total = x1 * 1000 + x2 * 1500 + x3 * 2000;
		vat = total / 10;
		totalt = total * 11 / 10;

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
