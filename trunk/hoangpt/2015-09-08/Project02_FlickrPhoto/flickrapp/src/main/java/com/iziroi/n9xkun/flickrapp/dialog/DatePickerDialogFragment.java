package com.iziroi.n9xkun.flickrapp.dialog;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

@SuppressLint("NewApi")
public class DatePickerDialogFragment extends DialogFragment implements
		DatePickerDialog.OnDateSetListener {
	
	// OnDateEnteredListener is implemented by the calling Activity
	public interface OnDateEnteredListener {
		public void OnDateEntered(int year, int monthOfYear, int dayOfMonth);
	}
	OnDateEnteredListener mListener;

	// Get current date and create the DatePickerDialog
	Calendar now = Calendar.getInstance();
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		DatePickerDialog dateDialog = new DatePickerDialog(this.getActivity(),
				this, 
				now.get(Calendar.YEAR), now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_MONTH));
		return dateDialog;
	}	
	
	// OnDateSet is required  to implement DatePickerDialog.OnDateSetListener
	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
    mListener.OnDateEntered(year, monthOfYear, dayOfMonth);
	}	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnDateEnteredListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnDateEnteredListener");
		}
	}
}
