package com.huytq.admin.applacai2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvNews = (ListView) findViewById(R.id.lvNews);
        String news[] = getResources().getStringArray(R.array.news);
        lvNews.setAdapter(new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1,  news));

        lvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = ((TextView) view).getText().toString();
                Intent intent = new Intent(getApplicationContext(), NewsDetail.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });
    }
}
