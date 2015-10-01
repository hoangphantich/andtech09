package com.hoangphan.tutor1303_cursorloader;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements LoaderCallbacks<Cursor> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// init cursor loader (async task)
		getLoaderManager().initLoader(1, null, this);
	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		// connect provider
		Uri CONTENT_URI = ContactsContract.RawContacts.CONTENT_URI;
		
		//query all contacts
		return new CursorLoader(this, CONTENT_URI, null, null, null, null);
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
		cursor.moveToFirst();
		StringBuilder res = new StringBuilder();
		
		// read database, simple adapter
		while (!cursor.isAfterLast()) {
			res.append("\n" + cursor.getString(21) + "-" + cursor.getString(22));

			cursor.moveToNext();
		}

		// display UI
		Log.d("contact", res.toString());

	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {

	}
}
