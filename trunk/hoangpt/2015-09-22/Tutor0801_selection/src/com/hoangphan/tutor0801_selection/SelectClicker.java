package com.hoangphan.tutor0801_selection;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SelectClicker implements OnClickListener {
	
	Activity context;
	
	public SelectClicker(Activity context) {
		this.context = context;
	}



	@Override
	public void onClick(View v) {
		Button b = (Button) v;
		String nameAct = b.getText().toString();
		
		//class name
		//reflection -> debugger
		try {
			Class<?> className = Class.forName("com.hoangphan.tutor0801_selection."+nameAct+"Activity");
			//start
			context.startActivity(new Intent(context, className));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
