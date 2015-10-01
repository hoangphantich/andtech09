package com.hoangphan.check03d;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MenuAdapter extends ArrayAdapter<String> {
	
	Context context;
	String[] menuList = new String[3];
	
	public MenuAdapter(Context context, int resource, String[] menuList) {
		super(context, resource, menuList);
		this.context = context;
		this.menuList = menuList;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
		if(convertView == null){
            vi = inflater.inflate(R.layout.list_item, null); //convert xml ->java
		}
		
        TextView title = (TextView) vi.findViewById(R.id.title); // title

        // Setting all values in listview
        title.setText(menuList[position]);
        return vi;
	}
}
