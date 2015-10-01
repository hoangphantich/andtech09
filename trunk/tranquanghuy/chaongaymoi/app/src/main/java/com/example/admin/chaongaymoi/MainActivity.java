package com.example.admin.chaongaymoi;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AnalogClock;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date date = new Date();
        AnalogClock ancClock = (AnalogClock) findViewById(R.id.ancClock);
        TextView txtHello = (TextView) findViewById(R.id.txtHello);

        int hour = date.getHours();

        if(hour <=12)
        {
            txtHello.setText("Good Morning");
            txtHello.setTextColor(Color.parseColor("#6fa3ff"));
        }else if(hour<=18){
            txtHello.setText("Good Afternoon");
            txtHello.setTextColor(Color.parseColor("#fb250d"));
        }else{
            txtHello.setText("Good Evening");
            txtHello.setTextColor(Color.YELLOW);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Date date = new Date();
        AnalogClock ancClock = (AnalogClock) findViewById(R.id.ancClock);
        TextView txtHello = (TextView) findViewById(R.id.txtHello);

        int hour = date.getHours();

        if(hour <=12)
        {
            txtHello.setText("Good Morning");
            txtHello.setTextColor(Color.parseColor("#6fa3ff"));
        }else if(hour<=18){
            txtHello.setText("Good Afternoon");
            txtHello.setTextColor(Color.parseColor("#fb2l50d"));
        }else{
            txtHello.setText("Good Evening");
            txtHello.setTextColor(Color.YELLOW);
        }
    }
}
