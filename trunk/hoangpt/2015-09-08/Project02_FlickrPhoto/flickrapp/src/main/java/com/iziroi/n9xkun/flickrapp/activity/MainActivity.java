package com.iziroi.n9xkun.flickrapp.activity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.iziroi.n9xkun.flickrapp.model.FlickrPhoto;
import com.iziroi.n9xkun.flickrapp.R;
import com.iziroi.n9xkun.flickrapp.dialog.AboutDialog;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

    private static final String API_KEY = "34497a532447de2519afad1fdf7ba7eb";
    private static final int NUMBER = 20;

    private android.app.ActionBar.Tab listTab;
    private android.app.ActionBar.Tab gridTab;

    private static final Long FLICKR_SUCCESSFULL = 1l;
    private static final Long FLICKR_FAIL = 0l;
    private ProgressBar progressBar;

    public ArrayList<FlickrPhoto> photos;
    private ActionBar.Tab galeryTab;

    /***************************************************
     * event and private method
     ***************************************************/

    private class LoadPhoto extends AsyncTask<String, String, Long> {
        @Override
        protected void onPostExecute(Long result) {
            if (result == FLICKR_SUCCESSFULL) {
                _showListPhoto();
            } else {
                Toast.makeText(getApplicationContext(), "Can't get photo list", Toast.LENGTH_LONG).show();
            }
            progressBar.setVisibility(View.GONE);
        }

        @Override
        protected Long doInBackground(String... params) {
            /* connect to flick */
            HttpURLConnection connection = null;
            try {
                URL flickUrl = new URL("https://api.flickr.com/services/rest/?method=flickr.photos.getRecent" +
                        "&api_key=" + API_KEY + "&per_page=" + NUMBER + "&format=json&nojsoncallback=1");
                connection = (HttpsURLConnection) flickUrl.openConnection();
                connection.connect();

                int status = connection.getResponseCode();
                if(200== status){
                    //read from input stream -->json class
                    InputStream is = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String responseString;
                    StringBuilder sb = new StringBuilder();
                    while ((responseString = reader.readLine()) != null) {
                        sb = sb.append(responseString);
                    }
                    String photoData = sb.toString();
                    Log.d("json", flickUrl.toString());
                    Log.d("json", photoData);

                    //build list of photo from json string
                    photos = FlickrPhoto.makePhotoListFromJson(photoData);

                    return FLICKR_SUCCESSFULL;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }

            return FLICKR_FAIL;
        }
    }


    private class NavListener implements android.app.ActionBar.TabListener {
        @Override
        public void onTabSelected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {
            if (tab.equals(listTab)) {
                _showListPhoto();
            } else {
              _showGridPhoto();
            }
        }

      @Override
        public void onTabUnselected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {
        }

        @Override
        public void onTabReselected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {

        }
    }

  private void _showGridPhoto() {
    Log.d("OK", "Grid photo");

    FlickrGridFragment flickrGridFragment = new FlickrGridFragment();
    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.fragment_container, flickrGridFragment);
    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
    fragmentTransaction.commit();
  }


  private void _showListPhoto() {
        Log.d("OK", "Vao day chua");

        FlickrListFragment flickrListFragment = new FlickrListFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, flickrListFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    private boolean _isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }


    /***************************************************
     * create ui and menu
     ***************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init view
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //check internet connection
        if(_isOnline()){
            LoadPhoto loadPhotoTask = new LoadPhoto();
            loadPhotoTask.execute();
        } else {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, "Please enable internet connection", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        //add tab
        android.app.ActionBar actionBar = getActionBar();
        if (actionBar != null) actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        listTab = actionBar.newTab().setText("List").setTabListener(new NavListener());
        gridTab = actionBar.newTab().setText("Grid").setTabListener(new NavListener());
        galeryTab = actionBar.newTab().setText("Galery").setTabListener(new NavListener());

        actionBar.addTab(listTab);
        actionBar.addTab(gridTab);
        actionBar.addTab(galeryTab);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Toast toast = Toast.makeText(getApplicationContext(), "tab", Toast.LENGTH_LONG);
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            toast.setText(R.string.menu_settings);
            toast.show();
            startActivity(new Intent(MainActivity.this, SettingActivity.class));
            return true;
        }

        if (id == R.id.action_about) {
            AboutDialog about = new AboutDialog();
            about.show(getFragmentManager(), "about");
        }

        return super.onOptionsItemSelected(item);
    }
}
