package nangsg_tipster.com;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {
	private ArrayList<Drink> drinkList;
	private ArrayAdapter<Drink> drinkAdp;
	private float price;
	private float totalFee;
	EditText edtQty, edtTotal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		price = 0;
		totalFee = 0;
		drinkList = new ArrayList<Drink>();
		drinkAdp = new ArrayAdapter<Drink>(MainActivity.this,
				android.R.layout.simple_spinner_item, drinkList);
		createDrink();
		Spinner spnDrink = (Spinner) findViewById(R.id.spnDrink);
		spnDrink.setAdapter(drinkAdp);

		// adding listener for spiner
		spnDrink.setOnItemSelectedListener(new SpinnerActivity());
		// Button
		edtQty = (EditText) findViewById(R.id.edtQty);
		edtQty.setText("0");
		edtTotal = ((EditText) findViewById(R.id.edtTotal));
		EditText edtVAT = (EditText) findViewById(R.id.edtVAT);
		edtVAT.setText("10%");
		// Button
		Button btnMinus = (Button) findViewById(R.id.btnMinus);
		Button btnPlus = (Button) findViewById(R.id.btnPlus);
		Button btnCalculate = (Button) findViewById(R.id.btnCalculate);

		btnMinus.setOnClickListener(new ButtonActivity());
		btnPlus.setOnClickListener(new ButtonActivity());
		btnCalculate.setOnClickListener(new ButtonActivity());
	}

	private void createDrink() {
		// TODO Auto-generated method stub
		Drink beer = new Drink("Beer", 10);
		Drink juice = new Drink("Juice", 20);
		Drink softdrink = new Drink("Soft-Drink", 5);

		drinkList.add(beer);
		drinkList.add(juice);
		drinkList.add(softdrink);
	}

	class SpinnerActivity implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			Drink drink = (Drink) parent.getItemAtPosition(pos);
			price = drink.getPrice();
			edtQty.setText("0");
			edtTotal.setText("");
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
		}
	}

	// For Button
	class ButtonActivity implements OnClickListener {

		@Override
		public void onClick(View v) {
			int qty = Integer.parseInt(((EditText) findViewById(R.id.edtQty))
					.getText().toString());
			switch (v.getId()) {
			case R.id.btnMinus:
				if(qty>0)
				qty = qty - 1;
				break;
			case R.id.btnPlus:
				qty = qty + 1;
				break;
			case R.id.btnCalculate:
				totalFee = price * qty + (price * qty) * 10 / 100;
				edtTotal.setText("" + totalFee);
				break;
			default:
				break;
			}
			((EditText) findViewById(R.id.edtQty)).setText("" + qty);
		}
	}
}
