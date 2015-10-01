package com.example.admin.deovuidau;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;


public class MainActivity extends Activity {

    int[] images = new int[] {R.drawable.buon, R.drawable.vui, R.drawable.tuc};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imvEmo = (ImageView) findViewById(R.id.imvEmo);
        Random random = new Random();
        int imageID = random.nextInt(images.length);

        imvEmo.setBackgroundResource(images[imageID]);
        imvEmo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int imageID = random.nextInt(images.length);
                ImageView imvEmo = (ImageView) findViewById(R.id.imvEmo);
                imvEmo.setBackgroundResource(images[imageID]);
            }
        });
    }
}
