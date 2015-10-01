package com.iziroi.n9xkun.flickrapp.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by hoangpt on 1/15/14.
 * entity, bean
 */
public class FlickrPhoto {

    String id;
    String owner;
    String secret;
    String server;
    String farm;
    public String title;
    Boolean isPublic;
    Boolean isFriend;
    Boolean isFamily;
    Boolean isFavorite=false;

    public FlickrPhoto() {
    }

    public FlickrPhoto(JSONObject photo) throws JSONException {
        this.id=(String) photo.optString("id");
        this.secret=(String) photo.optString("secret");
        this.owner=(String) photo.optString("owner");
        this.server=(String) photo.optString("server");
        this.farm=(String) photo.optString("farm");
        this.title=(String) photo.optString("title");
        this.isPublic=(Boolean) photo.optBoolean("ispublic");
        this.isFriend=(Boolean) photo.optBoolean("isfriend");
        this.isFamily=(Boolean) photo.optBoolean("isfamily");
        this.isFavorite = false;
    }

    public static ArrayList<FlickrPhoto> makePhotoListFromJson(String photoData) throws JSONException, NullPointerException {
        ArrayList<FlickrPhoto> photos = new ArrayList<FlickrPhoto>();

        //get json node
        JSONObject parentData = new JSONObject(photoData);
        JSONObject photosData = parentData.optJSONObject("photos");
        JSONArray photoArray = photosData.optJSONArray("photo");

        //iterate
        for (int i=0; i<photoArray.length(); i++) {
            JSONObject photo = (JSONObject) photoArray.get(i);
            FlickrPhoto currentPhoto = new FlickrPhoto(photo);
            photos.add(currentPhoto);
        }

        return photos;
    }



}
