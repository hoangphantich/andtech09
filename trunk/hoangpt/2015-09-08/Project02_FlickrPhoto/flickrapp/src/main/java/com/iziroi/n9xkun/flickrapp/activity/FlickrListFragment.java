package com.iziroi.n9xkun.flickrapp.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.iziroi.n9xkun.flickrapp.model.FlickrPhoto;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p />
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p />
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */


@SuppressLint("NewApi")
public class FlickrListFragment extends ListFragment {

    String[] titles = {"photo1", "photo2", "photo3"};

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MainActivity currentActivity = (MainActivity) this.getActivity();
        ArrayList<FlickrPhoto> photos = currentActivity.photos;

        if(photos != null){
            titles = new String[photos.size()];
            for (int i = 0; i < photos.size(); i++) {
                titles[i] = photos.get(i).title;
            }
        }

        setListAdapter(new ArrayAdapter<String>(currentActivity, android.R.layout.simple_list_item_1, titles));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
}
