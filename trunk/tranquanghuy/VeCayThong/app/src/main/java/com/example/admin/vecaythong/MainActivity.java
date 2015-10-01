package com.example.admin.vecaythong;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtStar = (TextView) findViewById(R.id.txtThong);
        TextView txtThanCay = (TextView) findViewById(R.id.txtThanCay);
        int i;
        int j;
        int k;

        for (i=0; i<9; i+=2)
        {
            for (k=9; k>=i; k--){
                txtStar.append(" ");
            }
            for (j=0; j<=i; j++)
            {
                txtStar.append("*");
                txtStar.append("");
            }
            txtStar.append("\n");
        }
        for (i=0; i<9; i+=2)
        {
            for (k=9; k>=2; k--)
            {
                txtStar.append(" ");
            }
            txtStar.append("*");
            txtStar.append("\n");
        }

    }
}
