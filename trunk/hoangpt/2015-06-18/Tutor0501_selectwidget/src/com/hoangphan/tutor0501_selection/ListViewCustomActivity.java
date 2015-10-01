package com.hoangphan.tutor0501_selection;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//
public class ListViewCustomActivity extends ListActivity {

	String[] cities = { "Hanoi", "Hue", "Danang" };
	String[] nameImg = { "1.jpg", "2.jpg", "3.jpg" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		CityAdapter adapter = new CityAdapter(this, R.layout.city_custom);
		setListAdapter(adapter);
	}

	class CityAdapter extends ArrayAdapter<String> {

		public CityAdapter(Context context, int resource) {
			super(context, resource, cities);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row = inflater.inflate(R.layout.city_custom, parent, false);

			TextView name = (TextView) row.findViewById(R.id.name);
			ImageView img = (ImageView) row.findViewById(R.id.img);

			name.setText(cities[position]);

			Bitmap bm = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath()
					+ "/Download/cover/" +nameImg[position]);
			img.setImageBitmap(bm);

			return row;
		}
	}

}
