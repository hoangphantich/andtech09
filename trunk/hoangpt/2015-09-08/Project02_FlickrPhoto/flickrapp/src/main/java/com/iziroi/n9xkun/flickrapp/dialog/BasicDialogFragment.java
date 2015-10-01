package com.iziroi.n9xkun.flickrapp.dialog;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.iziroi.n9xkun.flickrapp.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class BasicDialogFragment extends DialogFragment  {
	public interface OnNameEnteredListener {
		public void OnNameEntered(String nameEntered);
	}
	OnNameEnteredListener mListener;
	@SuppressLint("NewApi")
  @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnNameEnteredListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnNameEnteredListener");
        }
    }
	Button mOK;
	Button mCancel;
	EditText mNameField;
	@SuppressLint("NewApi")
  @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {		
		View v = inflater.inflate(R.layout.fragment_dialog_name, container, false);
    	getDialog().setTitle("First Name");
//    	getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
    	mNameField = (EditText)v.findViewById(R.id.editText1);
		mOK = (Button)v.findViewById(R.id.buttonOK);
		mOK.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mListener.OnNameEntered(mNameField.getText().toString());
				BasicDialogFragment.this.dismiss();
			}
		});
		mCancel = (Button)v.findViewById(R.id.buttonCancel);
		mCancel.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				BasicDialogFragment.this.dismiss();
			}
		});
		return v;
	}
}
