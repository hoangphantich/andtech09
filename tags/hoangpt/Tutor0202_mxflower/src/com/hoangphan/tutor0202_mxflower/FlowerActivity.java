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

package com.hoangphan.tutor0202_mxflower;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FlowerActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    //get ui from viewlayer
    final EditText flowerEdit = (EditText) findViewById(R.id.flowerEdit);
    final Button buyBtn = (Button) findViewById(R.id.buyBtn);
    final TextView orderTxt = (TextView) findViewById(R.id.orderTxt);
    
    //config events
    buyBtn.setOnClickListener(new View.OnClickListener() {
      
      @Override
      public void onClick(View v) {
       String flower = flowerEdit.getText().toString();
       flowerEdit.setText("");
       
       //add to order
       String before = orderTxt.getText().toString();
       String after = before + "\n" + flower;
       orderTxt.setText(after);
       
       //flash messenger
       Toast.makeText(getBaseContext(), "Anh mua "+flower+" <3", Toast.LENGTH_SHORT).show();
      }
    });
  }
}
