package com.hoangphan.tutor0202_flowerbuy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FlowerActivity extends Activity {

    private EditText edtFlower;
	private Button btnBuy;
	private TextView txtInvoice;
	
	int count = 1;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower);
        
        //get all ui element
        edtFlower = (EditText) findViewById(R.id.edtFlower);
        btnBuy = (Button) findViewById(R.id.btnBuy);
        txtInvoice = (TextView) findViewById(R.id.txtInvoice);
        
        //event
        //has name class
        btnBuy.setOnClickListener(new BuyListener());
    }
	
	/**
	 * event class
	 * @author hoangpt
	 */
	class BuyListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			//display progress dialog -> fake save to database
			final ProgressDialog dialog = new ProgressDialog(FlowerActivity.this);
			dialog.setTitle("Đợi em 3s để xem còn hoa không.");
			dialog.show();
			
			//display only 3s -> invalidate
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					dialog.dismiss();				
				}
			}).start();
			
			//get flowername
			String flowerName = edtFlower.getText().toString();
			Log.d("flower", flowerName);	
			
			//put into invoice area
			txtInvoice.append("\n"+flowerName);
			
			//reset form
			edtFlower.setText("");
			
			//flash messenger
			Toast.makeText(FlowerActivity.this, "Anh đã mua "+flowerName, Toast.LENGTH_SHORT).show();
			
			//count
			count++; //count = count+1
			Log.d("nr", count +"flowers");			
		}
	}
}
