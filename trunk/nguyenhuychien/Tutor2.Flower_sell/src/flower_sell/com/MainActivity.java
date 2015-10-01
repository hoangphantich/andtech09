package flower_sell.com;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {

	private EditText editText;
	private TextView listFlower;
	private Button buttonOK, buttonCheckOut;
	private String stringList = "Your oder:\n \n";
	private String stringToastPay = "Thank you for your oder on my flowers.\nMoney you must pay is: ";
	private String stringToastOder = "I have received your order at:\n";
	private String stringToastMoney = "If i do not received money on (3 days):\n";
	private String stringToastCancel = "Your order will be canceled.";
	private int money = 0, days = 4;
	private Calendar oderCalendar, endCalendar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editText = (EditText) findViewById(R.id.editText1);
		buttonOK = (Button) findViewById(R.id.btnOK);
		buttonCheckOut = (Button) findViewById(R.id.btnCheckOut);
		listFlower = (TextView) findViewById(R.id.txtList);

		listFlower.setText(stringList);

		buttonOK.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				String nameFlower = editText.getText().toString();
				if (!nameFlower.equals("")) {
					Toast.makeText(
							MainActivity.this,
							"\""
									+ nameFlower
									+ "\""
									+ " add to oder successfully, i will contact with you sooner ",
							Toast.LENGTH_SHORT).show();
					stringList = stringList + "  Hoa " + nameFlower + "\n";
					listFlower.setText(stringList);
					money += 1000;
					oderCalendar = Calendar.getInstance();
					endCalendar = Calendar.getInstance();
					endCalendar.add(Calendar.DAY_OF_YEAR, days);
					clearText();
				}
			}

		});
		buttonCheckOut.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (money != 0) {
					String orderTime = new SimpleDateFormat(
							"  dd/MM/yyyy HH:mm:ss").format(oderCalendar
							.getTime());
					String endTime = new SimpleDateFormat(
							"  dd/MM/yyyy HH:mm:ss").format(endCalendar
							.getTime());
					Toast.makeText(
							MainActivity.this,
							stringToastPay + money + "$\n" + stringToastOder
									+ orderTime + ".\n" + stringToastMoney
									+ endTime + ".\n" + stringToastCancel,
							Toast.LENGTH_LONG).show();
				}
			}
		});

	}

	void clearText() {
		// TODO Auto-generated method stub
		editText.setText("");
		editText.requestFocus();
	}
}
