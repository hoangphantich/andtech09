package com.iziroi.n9xkun.flickrapp.activity;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iziroi.n9xkun.flickrapp.R;

/**
 * Created by phantichhoang on 5/20/2014.
 */
@SuppressLint("NewApi")
public class FlickrGridFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.layout_grid_photo, container, false);
    return v;
  }
}
