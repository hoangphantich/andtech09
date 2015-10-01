package com.huytq.admin.dota2predict;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button btnPredict = (Button) view.findViewById(R.id.btnPredict);
        final EditText txtTeam1 = (EditText) view.findViewById(R.id.txtTeam1);
        final EditText txtTeam2 = (EditText) view.findViewById(R.id.txtTeam2);
        final TextView txtTeamWin = (TextView) view.findViewById(R.id.txtTeamWin);

        btnPredict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String team1 = txtTeam1.getText().toString();
                String team2 = txtTeam2.getText().toString();
                String teamWin = "";

                String[] arr = {team1, team2};

                for (int i=0; i<21; i++){
                    teamWin = arr[new Random().nextInt(arr.length)];
                }
                txtTeamWin.setText(teamWin);
            }
        });

        return view;
    }
}
