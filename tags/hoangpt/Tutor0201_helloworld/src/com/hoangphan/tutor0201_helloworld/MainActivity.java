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

package com.hoangphan.tutor0201_helloworld;

import android.os.*;
import android.app.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {

	TextView helloTxt;
	EditText nameEdit;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);

		// create textview hello world, like swing, first is layout
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);

		//add textview to layout
		helloTxt = new TextView(this);
		helloTxt.setText("Welcome to Android world");

		//add edittext to layout
		nameEdit = new EditText(this);
		nameEdit.setHint("Enter your name");
		nameEdit.setLines(1);

		layout.addView(helloTxt);
		layout.addView(nameEdit);

		nameEdit.setOnKeyListener(new NameListener());
		setContentView(layout);
	}
	
  public class NameListener implements View.OnKeyListener {

    public boolean onKey(View v, int keyCode, KeyEvent event) {
      if (KeyEvent.ACTION_DOWN == event.getAction()
          && KeyEvent.KEYCODE_ENTER == keyCode) {
        String name = nameEdit.getText().toString();
        nameEdit.setText("");// reset
        helloTxt.setText("Welcome to Android world, " + name + ".");
        return true;
      } else {
        return false;
      }
    }
  }
}
