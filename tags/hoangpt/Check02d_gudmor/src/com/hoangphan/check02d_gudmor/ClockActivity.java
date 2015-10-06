/**
 * http://iziroi.9xkun.com
 * 
 * LICENSE
 * 
 * This source file is belong to iziroi.9xkun.com. Please come to this site and
 * get more source code. If you have any question, please send email to me at: 
 * phantichhoang@gmail.com
 * 
 * @copyright Copyright (c) 2013-2014 iziroi
 * @author hoangpt
 * @version $Id$
 * @since
 */

package com.hoangphan.check02d_gudmor;

import java.util.Calendar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ClockActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clock);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		//get UI
		TextView txtHello = (TextView) findViewById(R.id.txtHello);
		
		//get time
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		
		//compare time to 6, 12, 18h -> suitable hello message
		String helloMsg = "Good morning"; //default
		
		if(hour<=12){
			helloMsg = "Good morning";
			txtHello.setTextColor(Color.GREEN);
		} else if(hour<=18){
			helloMsg = "Good afternoon";
			txtHello.setTextColor(Color.YELLOW);
		} else {
			helloMsg = "Good evening";
			txtHello.setTextColor(Color.RED);
		}
		txtHello.setText(helloMsg);		
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.clock, menu);
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
