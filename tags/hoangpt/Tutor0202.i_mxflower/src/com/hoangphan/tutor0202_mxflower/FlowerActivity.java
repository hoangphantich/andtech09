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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FlowerActivity extends Activity {

  private int amount;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    final EditText flowerEdit = (EditText) findViewById(R.id.flowerEdit);
    final Button buyBtn = (Button) findViewById(R.id.buyBtn);
    final TextView orderTxt = (TextView) findViewById(R.id.orderTxt);
    amount = 0;
    
    buyBtn.setOnClickListener(new View.OnClickListener() {
      
      @Override
      public void onClick(View v) {
       String flower = flowerEdit.getText().toString();
       if(!flower.equals("")){
         flowerEdit.setText(""); //reset
         
         //add to order
         String before = orderTxt.getText().toString();
         String after = before + "\n" + flower;
         orderTxt.setText(after);
         amount ++;
         
         //flash messenger
         Toast.makeText(getBaseContext(), "Anh mua "+flower+" <3", Toast.LENGTH_SHORT).show();
       }
      }
    });
    
    final Button checkoutBtn = (Button) findViewById(R.id.checkoutBtn);
    checkoutBtn.setOnClickListener(new View.OnClickListener() {
      
      @Override
      public void onClick(View v) {
        Calendar cal = Calendar.getInstance();
        Date now = cal.getTime();
        cal.add(Calendar.DATE, 3);
        Date expire = cal.getTime();
        
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String nowStr = formater.format(now);
        String expireStr = formater.format(expire);
        
        String msg = "Cám ơn anh đã mua hoa cho em\n"+
            "Số tiền mà anh cần chuyển khoản là: "+amount*1000+"$\n"+
            "Em đã nhận order của anh vào lúc "+nowStr+".\n"+
            "Nếu em không nhận được tiền trước "+expireStr+", order của anh sẽ bị huỷ.\n"+
            "I love you, sir.";
        new AlertDialog.Builder(FlowerActivity.this)
          .setTitle("Receipt for flower")
          .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            
            @Override
            public void onClick(DialogInterface dialog, int which) {
              System.out.println("OK");
            }
          })
          .setMessage(msg)
          .show();
      }
    });
  }
}
