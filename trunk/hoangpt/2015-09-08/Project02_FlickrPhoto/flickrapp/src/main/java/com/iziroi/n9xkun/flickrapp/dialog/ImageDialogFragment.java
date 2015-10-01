package com.iziroi.n9xkun.flickrapp.dialog;


import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.iziroi.n9xkun.flickrapp.R;

@SuppressLint("NewApi")
public class ImageDialogFragment extends DialogFragment  {
	

	Button mCancel;
	EditText mNameField;
	@SuppressLint("NewApi")
  @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {		
		View v = inflater.inflate(R.layout.fragment_dialog_image, container, false);
    	getDialog().setTitle("Android Robot Image");
//    	mNameField = (EditText)v.findViewById(R.id.editText1);		
//		mCancel = (Button)v.findViewById(R.id.buttonCancel);
//		mCancel.setOnClickListener(new OnClickListener() {
//			public void onClick(View v) {
//				ImageDialogFragment.this.dismiss();
//			}
//		});
		return v;

	}
}
