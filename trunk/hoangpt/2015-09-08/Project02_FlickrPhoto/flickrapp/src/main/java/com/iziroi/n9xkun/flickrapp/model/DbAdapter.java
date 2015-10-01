package com.iziroi.n9xkun.flickrapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by hoangpt on 1/22/14.
 */
public class DbAdapter {
    public static final String _KEYID = "_id";
    public static final String[] FLICKR_FIELD = new String[] {
            _KEYID,
            "flickr_id",
            "owner",
            "secret",
            "server",
            "farm",
            "title",
            "isPublic",
            "isFriend",
            "isFamily",
            "isFavorite"
    };

    private static final String DB_CREATE =
            "create table flickrphoto (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "flickr_id not null,"
                    + "owner text,"
                    + "secret text,"
                    + "server text,"
                    + "farm text,"
                    + "title text,"
                    + "isPublic INTEGER,"
                    + "isFriend INTEGER,"
                    + "isFamily INTEGER,"
                    + "isFavorite INTEGER"
                    +");";

    private DbHelper dbHelper;
    public SQLiteDatabase db;
    public Context context;

    private static final String DB_NAME = "FLICKR_PHOTOS";
    private static final String DB_TABLE = "flickrphoto";
    private static final int DB_VERSION = 1;


    private static class DbHelper extends SQLiteOpenHelper {

        public DbHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE);
            onCreate(db);
        }
    }


    /**********************************
     * CONNECT, CLOST, AND CRUD
     ***********************************/

    public DbAdapter(Context context) {
        this.context = context;
    }

    public DbAdapter open() throws SQLException {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if(dbHelper!=null){
            dbHelper.close();
        }
    }

    public void upgrade() throws SQLException {
        dbHelper = new DbHelper(context); //open
        db = dbHelper.getWritableDatabase();
        dbHelper.onUpgrade(db, 1, 0);
    }


    public long createPhoto(FlickrPhoto photoToCreate) {
        ContentValues initialValues = new ContentValues();
        if (photoToCreate.id!=null)
            initialValues.put("flickr_id", photoToCreate.id);
        if (photoToCreate.owner!=null)
            initialValues.put("owner", photoToCreate.owner);
        if (photoToCreate.secret!=null)
            initialValues.put("secret", photoToCreate.secret);
        if (photoToCreate.server!=null)
            initialValues.put("server", photoToCreate.server);
        if (photoToCreate.farm!=null)
            initialValues.put("farm", photoToCreate.farm);
        if (photoToCreate.title!=null)
            initialValues.put("title", photoToCreate.title);
        if (photoToCreate.isPublic!=null)
            initialValues.put("isPublic", photoToCreate.isPublic);
        if (photoToCreate.isFriend!=null)
            initialValues.put("isFriend", photoToCreate.isFriend);
        if (photoToCreate.isFamily!=null)
            initialValues.put("isFamily", photoToCreate.isFamily);
        if (photoToCreate.isFavorite!=null)
            initialValues.put("isFavorite", photoToCreate.isFavorite);
        return db.insert(DB_TABLE, null, initialValues);
    }

    public boolean deletePhoto(long rowId) {
        return db.delete(DB_TABLE, _KEYID + "=" + rowId, null) > 0;
    }

    public boolean deletePhoto(String photo_id) {
        return db.delete(DB_TABLE, "flickr_id" + "=" + photo_id, null) > 0;
    }


    public Cursor fetchPhotos() {
        return db.query(DB_TABLE, FLICKR_FIELD, null, null, null, null, null);
    }


    public Cursor fetchById(long rowId) throws SQLException {
        Cursor cursor =  db.query(true, DB_TABLE, FLICKR_FIELD, _KEYID + "=" + rowId, null,
                        null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;

    }

    public Cursor fetchByFlickrId(String flickrId) throws SQLException {
        Cursor mCursor =
                db.query(true, DB_TABLE, FLICKR_FIELD, "flickr_id" + "='" + flickrId+"'", null,
                        null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor fetchFavorites() throws SQLException {
        Cursor mCursor =
                db.query(true, DB_TABLE, FLICKR_FIELD, "isFavorite=1", null,
                        null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    public FlickrPhoto getPhotoByFlickrId(String id){
        FlickrPhoto photo = null;
        Cursor photoCursor = null;
        try {
            photoCursor = fetchByFlickrId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (photoCursor.moveToFirst()){
            photo= getPhotoFromCursor(photoCursor);
        }
        if (photoCursor!=null){
            photoCursor.close();
        }
        return photo;
    }


    public static FlickrPhoto getPhotoFromCursor(Cursor cursor){
        FlickrPhoto photo = new FlickrPhoto();
        photo.id = cursor.getString(cursor.getColumnIndex("flickr_id"));
        photo.owner = cursor.getString(cursor.getColumnIndex("owner"));
        photo.secret = cursor.getString(cursor.getColumnIndex("secret"));
        photo.server = cursor.getString(cursor.getColumnIndex("server"));
        photo.farm = cursor.getString(cursor.getColumnIndex("farm"));
        photo.title = cursor.getString(cursor.getColumnIndex("title"));
        photo.isPublic = (cursor.getInt(cursor.getColumnIndex("isPublic")) == 1);
        photo.isFriend = (cursor.getInt(cursor.getColumnIndex("isFriend")) == 1);
        photo.isFamily = (cursor.getInt(cursor.getColumnIndex("isFamily")) == 1);
        photo.isFavorite = (cursor.getInt(cursor.getColumnIndex("isFavorite")) == 1);
        return(photo);
    }


    public boolean updatePhoto(String id, FlickrPhoto photoToUpdate) {
        ContentValues updateValues = new ContentValues();
        if (photoToUpdate.id!=null)
            updateValues.put("flickr_id", photoToUpdate.id);
        if (photoToUpdate.owner!=null)
            updateValues.put("owner", photoToUpdate.owner);
        if (photoToUpdate.secret!=null)
            updateValues.put("secret", photoToUpdate.secret);
        if (photoToUpdate.server!=null)
            updateValues.put("server", photoToUpdate.server);
        if (photoToUpdate.farm!=null)
            updateValues.put("farm", photoToUpdate.farm);
        if (photoToUpdate.title!=null)
            updateValues.put("title", photoToUpdate.title);
        if (photoToUpdate.isPublic!=null)
            updateValues.put("isPublic", photoToUpdate.isPublic);
        if (photoToUpdate.isFriend!=null)
            updateValues.put("isFriend", photoToUpdate.isFriend);
        if (photoToUpdate.isFamily!=null)
            updateValues.put("isFamily", photoToUpdate.isFamily);
        if (photoToUpdate.isFavorite!=null)
            updateValues.put("isFavorite", photoToUpdate.isFavorite);
        return db.update(DB_TABLE, updateValues, "flickr_id" + "=" + id, null) > 0;
    }

}
