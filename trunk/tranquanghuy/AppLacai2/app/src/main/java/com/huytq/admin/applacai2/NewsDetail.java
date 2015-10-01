package com.huytq.admin.applacai2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class NewsDetail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
        Intent i = getIntent();
        String title = i.getStringExtra("title");
        txtTitle.setText(title);
    }
}
