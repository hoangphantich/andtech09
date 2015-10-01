package com.andhradroid.swipedeletedemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.andhradroid.swipedeletedemo.SwipeListView.SwipeListViewCallback;

public class MainActivity extends Activity implements SwipeListViewCallback {

	private ListView list;
	private MyAdapter m_Adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		list = (ListView) findViewById(R.id.listView1);
		SwipeListView l = new SwipeListView(this, this);
		l.exec();
		m_Adapter = new MyAdapter();
		for (int i = 1; i < 30; i++) {
			m_Adapter.addItem("Item " + i);
		}
		//
		list.setAdapter(m_Adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public ListView getListView() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public void onSwipeItem(boolean isRight, int position) {
		// TODO Auto-generated method stub
		m_Adapter.onSwipeItem(isRight, position);
	}

	@Override
	public void onItemClickListener(ListAdapter adapter, int position) {
		// TODO Auto-generated method stub

	}

	//extend BaseAdapter
	public class MyAdapter extends BaseAdapter {

		protected List<String> m_List;
		private final int INVALID = -1;
		protected int DELETE_POS = -1;

		public MyAdapter() {
			// TODO Auto-generated constructor stub
			m_List = new ArrayList<String>();
		}

		public void addItem(String item) {
			//
			m_List.add(item);
			notifyDataSetChanged();
		}

		public void addItemAll(List<String> item) {
			//
			m_List.addAll(item);
			notifyDataSetChanged();
		}

		public void onSwipeItem(boolean isRight, int position) {
			// TODO Auto-generated method stub
			if (isRight == false) {
				DELETE_POS = position;
			} else if (DELETE_POS == position) {
				DELETE_POS = INVALID;
			}
			//
			notifyDataSetChanged();
		}

		public void deleteItem(int pos) {
			//
			m_List.remove(pos);
			DELETE_POS = INVALID;
			notifyDataSetChanged();
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return m_List.size();
		}

		@Override
		public String getItem(int position) {
			// TODO Auto-generated method stub
			return m_List.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				convertView = LayoutInflater.from(MainActivity.this).inflate(
						R.layout.item, null);
			}
			TextView text = ViewHolderPattern.get(convertView, R.id.text);
			Button delete = ViewHolderPattern.get(convertView, R.id.delete);
			if (DELETE_POS == position) {
				delete.setVisibility(View.VISIBLE);
			} else
				delete.setVisibility(View.GONE);
			delete.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					deleteItem(position);
				}
			});

			text.setText(getItem(position));

			return convertView;
		}
	}

	public static class ViewHolderPattern {
		// I added a generic return type to reduce the casting noise in client
		// code
		@SuppressWarnings("unchecked")
		public static <T extends View> T get(View view, int id) {
			SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
			if (viewHolder == null) {
				viewHolder = new SparseArray<View>();
				view.setTag(viewHolder);
			}
			View childView = viewHolder.get(id);
			if (childView == null) {
				childView = view.findViewById(id);
				viewHolder.put(id, childView);
			}
			return (T) childView;
		}
	}
}
