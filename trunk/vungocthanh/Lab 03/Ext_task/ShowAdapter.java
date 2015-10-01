package com.example.ext_task;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ShowAdapter extends BaseAdapter {
	
	Activity context;
	ArrayList<Information> myArray;
	int layoutId;
	
	public ShowAdapter(Activity context, int layoutId,
			ArrayList<Information> myArray) {

		this.context = context;         // context la activity tu main
		this.layoutId = layoutId;		// layoutid la layout custom do ta tao ( item )
		this.myArray = myArray;			// myArray la array truyen tu main
	}

	
	// ham dung de custom listview ta phai override ham nay
	// position la vi tri phan tu cua danh sach item
	// convertView : la View de xu ly item
	// parent : danh sach nhan vien truyen tu main
	@SuppressLint("ViewHolder")
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = context.getLayoutInflater();
		convertView = inflater.inflate(layoutId, null);
		
		TextView tv = (TextView) convertView.findViewById(R.id.textView1);	
		
		tv.setText(myArray.get(position).show());
		
		return convertView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return myArray.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return myArray.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	
	
}
