package com.iziroi.n9xkun.flickrapp.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.iziroi.n9xkun.flickrapp.R;
import com.iziroi.n9xkun.flickrapp.dialog.TimePickerDialogFragment;
import com.iziroi.n9xkun.flickrapp.dialog.BasicAlertDialogFragment;
import com.iziroi.n9xkun.flickrapp.dialog.BasicDialogFragment;
import com.iziroi.n9xkun.flickrapp.dialog.CustomAlertDialogFragment;
import com.iziroi.n9xkun.flickrapp.dialog.DatePickerDialogFragment;
import com.iziroi.n9xkun.flickrapp.dialog.ImageDialogFragment;
import com.iziroi.n9xkun.flickrapp.dialog.ListAlertDialogFragment;


public class SettingActivity extends Activity implements BasicDialogFragment.OnNameEnteredListener, CustomAlertDialogFragment.OnNameEnteredListener,
  DatePickerDialogFragment.OnDateEnteredListener, TimePickerDialogFragment.OnTimeEnteredListener {

    @Override
    @SuppressLint("NewApi")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

      Button button1 = (Button)findViewById(R.id.button1);
      button1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          BasicDialogFragment basicDialog = new BasicDialogFragment();
          basicDialog.show(getFragmentManager(), "basic");
        }
      });
      Button button2 = (Button)findViewById(R.id.button2);
      button2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          DatePickerDialogFragment dateDialog = new DatePickerDialogFragment();
          dateDialog.show(getFragmentManager(), "date");
        }
      });

      Button button3 = (Button)findViewById(R.id.button3);
      button3.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          TimePickerDialogFragment timeDialog = new TimePickerDialogFragment();
          timeDialog.show(getFragmentManager(), "time");
        }
      });

      Button button4 = (Button)findViewById(R.id.button4);
      button4.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          ImageDialogFragment imageDialog = new ImageDialogFragment();
//	        	imageDialog.setStyle(DialogFragment.STYLE_NO_FRAME, 0);
          imageDialog.show(getFragmentManager(), "image");
        }
      });

      Button button5 = (Button)findViewById(R.id.button5);
      button5.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          BasicAlertDialogFragment alertDialog = new BasicAlertDialogFragment();
          alertDialog.show(getFragmentManager(), "alert");
        }
      });
      Button button6 = (Button)findViewById(R.id.button6);
      button6.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
          ListAlertDialogFragment alertDialog = new ListAlertDialogFragment();
          alertDialog.show(getFragmentManager(), "list alert");
        }
      });
      Button button7 = (Button)findViewById(R.id.button7);
      button7.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          CustomAlertDialogFragment alertDialog = new CustomAlertDialogFragment();
          alertDialog.show(getFragmentManager(), "list alert");
        }
      });
    }

  @Override
  public void OnNameEntered(String answer) {
    Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void OnDateEntered(int year, int monthOfYear, int dayOfMonth) {
    Toast.makeText(getApplicationContext(), dayOfMonth + "." + monthOfYear +"."+ year , Toast.LENGTH_SHORT).show();

  }

  @Override
  public void OnTimeEntered(int hour, int minute) {
    Toast.makeText(getApplicationContext(), hour + ":" +minute  , Toast.LENGTH_SHORT).show();

  }
}
