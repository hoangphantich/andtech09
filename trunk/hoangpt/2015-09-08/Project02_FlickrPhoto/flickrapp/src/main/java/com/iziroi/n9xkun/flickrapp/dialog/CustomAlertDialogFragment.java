package com.iziroi.n9xkun.flickrapp.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

import com.iziroi.n9xkun.flickrapp.R;

@SuppressLint("NewApi")
public class CustomAlertDialogFragment extends DialogFragment{
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
	@Override
  @SuppressLint("NewApi")
  public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	    LayoutInflater inflater = getActivity().getLayoutInflater();
	    builder.setView(inflater.inflate(R.layout.fragment_alert_dialog_name, null))
	           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	           	       EditText nameText = (EditText) getDialog().findViewById(R.id.editText1);
	            	   mListener.OnNameEntered(nameText.getText().toString());
	               }
	           })
	           .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	               }
	           });      
	    return builder.create();
	}
}
