package com.huytq.admin.dota2predict;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPredict = (Button) findViewById(R.id.btnPredict);
        final EditText txtTeam1 = (EditText) findViewById(R.id.txtTeam1);
        final EditText txtTeam2 = (EditText) findViewById(R.id.txtTeam2);
        final TextView txtTeamWin = (TextView) findViewById(R.id.txtTeamWin);

        btnPredict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String team1 = txtTeam1.getText().toString();
                String team2 = txtTeam2.getText().toString();
                String teamWin = "";

                String[] arr = {team1, team2};

                for (int i = 0; i < 21; i++) {
                    teamWin = arr[new Random().nextInt(arr.length)];
                }
                txtTeamWin.setText(teamWin);
            }
        });
    }
}
