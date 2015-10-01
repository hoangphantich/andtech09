package com.huytq.admin.applacai;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvNews = (ListView) findViewById(R.id.lvNews);
        String news[] = getResources().getStringArray(R.array.news);
        ArrayAdapter<String> adapter;
        lvNews.setAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.lvNews, news));
    }
}
