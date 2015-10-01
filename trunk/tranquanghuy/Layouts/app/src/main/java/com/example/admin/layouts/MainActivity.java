package com.example.admin.layouts;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);
        Button btnFrame = (Button) findViewById(R.id.btnFrame);
        ImageView imgWifi = (ImageView) findViewById(R.id.imvWifi);
        ImageView img3G = (ImageView) findViewById(R.id.imv3G);
        imgWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            }
        });
        img3G.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS));
            }
        });
        btnFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FrameLayout.class);
                startActivity(intent);
            }
        });
    }


}
