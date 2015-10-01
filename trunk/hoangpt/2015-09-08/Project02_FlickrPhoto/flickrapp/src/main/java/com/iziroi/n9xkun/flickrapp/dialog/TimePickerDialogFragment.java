package com.iziroi.n9xkun.flickrapp.dialog;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

@SuppressLint("NewApi")
public class TimePickerDialogFragment extends DialogFragment implements	TimePickerDialog.OnTimeSetListener{

	public interface OnTimeEnteredListener {
		public void OnTimeEntered(int hour, int minute);
	}

	OnTimeEnteredListener mListener;

	Calendar now = Calendar.getInstance();

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
		TimePickerDialog dateDialog = new TimePickerDialog(
				this.getActivity(),
				this,
				hour, minute, false);
		return dateDialog;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnTimeEnteredListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnTimeEnteredListener");
		}
	}


	@Override
	public void onTimeSet(TimePicker view, int hour, int minute) {
		mListener.OnTimeEntered(hour, minute);
	}

}
