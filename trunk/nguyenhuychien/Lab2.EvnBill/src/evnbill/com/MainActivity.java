package evnbill.com;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ProgressDialog progressBar;
	private int progressBarStatus = 0;

	private Handler progressBarbHandler = new Handler();
	private long printSize = 0;

	// declare object control
	private EditText edittextName;
	private EditText edittexQuantity;
	private ListView listviewInvoice;
	private TextView txttotalFee;
	private TextView txttotalVAT;
	private TextView txttotalIncludeVAT;

	private static List<Invoice> listInvoice;

	// Format number
	DecimalFormat df = new DecimalFormat("#,###,###,##0");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Find object Control
		edittextName = (EditText) findViewById(R.id.edittextName);
		edittexQuantity = (EditText) findViewById(R.id.edittexQuantity);
		listviewInvoice = (ListView) findViewById(R.id.listviewInvoice);
		txttotalFee = (TextView) findViewById(R.id.txttotalFee);
		txttotalVAT = (TextView) findViewById(R.id.txttotalVAT);
		txttotalIncludeVAT = (TextView) findViewById(R.id.txttotalIncludeVAT);
	}

	public void btnCalculate_OnClick(View v) {
		if (edittextName.getText().toString().equals("")) {
			edittextName.requestFocus();
			Toast.makeText(this, "Pls input Name", Toast.LENGTH_SHORT).show();
			return;
		}
		listInvoice = new ArrayList<Invoice>();
		if (edittexQuantity.getText().toString().equals("")) {
			edittexQuantity.requestFocus();
			Toast.makeText(this, "Pls input quantity", Toast.LENGTH_SHORT)
					.show();
			return;
		}
		// Calculate
		int quantity = Integer.parseInt(edittexQuantity.getText().toString());
		if (quantity > 0 && quantity <= 100)
			listInvoice.add(new Invoice(quantity, 1000));
		else if (quantity > 0 && quantity <= 150) {
			listInvoice.add(new Invoice(100, 1000));
			listInvoice.add(new Invoice(quantity - 100, 1500));
		} else if (quantity > 0 && quantity <= 200) {
			listInvoice.add(new Invoice(100, 1000));
			listInvoice.add(new Invoice(50, 1500));
			listInvoice.add(new Invoice(quantity - 150, 2000));
		} else if (quantity > 0 && quantity <= 300) {
			listInvoice.add(new Invoice(100, 1000));
			listInvoice.add(new Invoice(50, 1500));
			listInvoice.add(new Invoice(50, 2000));
			listInvoice.add(new Invoice(quantity - 200, 2500));
		} else if (quantity > 0 && quantity <= 400) {
			listInvoice.add(new Invoice(100, 1000));
			listInvoice.add(new Invoice(50, 1500));
			listInvoice.add(new Invoice(50, 2000));
			listInvoice.add(new Invoice(100, 2500));
			listInvoice.add(new Invoice(quantity - 300, 3000));
		} else {
			listInvoice.add(new Invoice(100, 1000));
			listInvoice.add(new Invoice(50, 1500));
			listInvoice.add(new Invoice(50, 2000));
			listInvoice.add(new Invoice(100, 2500));
			listInvoice.add(new Invoice(100, 3000));
			listInvoice.add(new Invoice(quantity - 400, 3500));
		}
		ArrayAdapter<Invoice> adapter = new ArrayAdapter<Invoice>(this,
				android.R.layout.simple_list_item_1, listInvoice);

		listviewInvoice.setAdapter(adapter);

		// Calculate total fee
		double totalFee = 0;
		if (listInvoice != null && listInvoice.size() > 0) {
			for (Invoice itemInvoice : listInvoice) {
				totalFee += itemInvoice.getPrice() * itemInvoice.getQuantity();
			}
		}
		txttotalFee.setText(df.format(totalFee));
		txttotalVAT.setText(df.format(totalFee * 10 / 100));
		txttotalIncludeVAT.setText(df.format(totalFee + totalFee * 10 / 100));

	}

	public void btnPrint_OnClick(View v) {
		// create and display a new ProgressBarDialog

		progressBar = new ProgressDialog(v.getContext());
		progressBar.setCancelable(true);
		progressBar.setMessage("Printing Invoice for "
				+ edittextName.getText().toString() + "...");
		progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressBar.setProgress(0);
		progressBar.setMax(100);
		progressBar.setButton(DialogInterface.BUTTON_NEGATIVE, "Done",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// close the ProgressDialog
						progressBar.dismiss();
						Toast.makeText(getBaseContext(), "Print done!",
								Toast.LENGTH_SHORT).show();
					}
				});
		progressBar.show();
		progressBar.getButton(ProgressDialog.BUTTON_NEGATIVE).setEnabled(false);
		progressBarStatus = 0;

		printSize = 0;

		new Thread(new Runnable() {

			public void run() {
				while (progressBarStatus < 100) {
					progressBarStatus = PrintSimulate();

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					// Update the progress bar
					progressBarbHandler.post(new Runnable() {
						public void run() {
							progressBar.setProgress(progressBarStatus);
						}
					});
				}
				if (progressBarStatus >= 100) {
					try {
						progressBar.getButton(ProgressDialog.BUTTON_NEGATIVE)
								.setEnabled(true);
					} catch (Exception ex) {
					}
				}
			}

		}).start();

	}

	// file Process simulator...
	public int PrintSimulate() {
		while (printSize <= 1000000) {

			printSize++;

			if (printSize == 100000) {
				return 10;

			} else if (printSize == 200000) {
				return 20;
			} else if (printSize == 300000) {
				return 30;
			} else if (printSize == 400000) {
				return 40;
			} else if (printSize == 500000) {
				return 50;
			} else if (printSize == 600000) {
				return 60;
			} else if (printSize == 700000) {
				return 70;
			} else if (printSize == 800000) {
				return 80;
			} else if (printSize == 900000) {
				return 90;
			}
		}
		return 100;
	}
}
