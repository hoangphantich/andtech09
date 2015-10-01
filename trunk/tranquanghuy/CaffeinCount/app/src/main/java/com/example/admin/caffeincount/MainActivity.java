package com.example.admin.caffeincount;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    public int pos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnPlus = (Button) findViewById(R.id.btnPlus);
        TextView txtWeight = (TextView) findViewById(R.id.txtWeight);
        TextView txtMaxCafe = (TextView) findViewById(R.id.txtMaxCafe);
        final TextView txtCountStar = (TextView) findViewById(R.id.txtCount);
        final TextView txtCountMilk = (TextView) findViewById(R.id.txtCountMilk);
        final TextView txtCountBlack = (TextView) findViewById(R.id.txtCountBlack);
        final TextView txtGStar = (TextView) findViewById(R.id.txtG);
        final TextView txtGMilk = (TextView) findViewById(R.id.txtGMilk);
        TextView txtGBlack = (TextView) findViewById(R.id.txtGBlack);
        TextView txtTotal = (TextView) findViewById(R.id.txtTotal);
        final Spinner spnCafeType = (Spinner) findViewById(R.id.spnCafeType);

        //int weight = Integer.parseInt(edtWeight.getText().toString());
        //int totalCafein = (100 + weight) / 1200000;

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Cafe_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCafeType.setAdapter(adapter);
        spnCafeType.setOnItemSelectedListener(this);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pos == 0){
                    btnPlus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int count = Integer.parseInt(txtCountStar.getText().toString());
                            String c = String.valueOf(count + 1);
                            txtCountStar.setText(c);
                            txtGStar.setText(c);
                        }
                    });
                }else if(pos == 1){
                    btnPlus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int count = Integer.parseInt(txtCountMilk.getText().toString());
                            String c = String.valueOf(count + 1);
                            txtCountMilk.setText(c);
                            String g = String.valueOf((count + 1)*5);
                            txtGMilk.setText(g);
                        }
                    });
                }else if (pos == 2){
                    btnPlus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int count = Integer.parseInt(txtCountBlack.getText().toString());
                            String c = String.valueOf(count + 1);
                            txtCountBlack.setText(c);
                            String g = String.valueOf((count + 1)*10);
                            txtGMilk.setText(g);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}
