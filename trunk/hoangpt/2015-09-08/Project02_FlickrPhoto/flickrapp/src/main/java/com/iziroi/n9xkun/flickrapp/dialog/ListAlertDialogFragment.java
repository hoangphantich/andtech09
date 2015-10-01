package com.iziroi.n9xkun.flickrapp.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class ListAlertDialogFragment extends DialogFragment{
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		String[] items ={"Beef", "Fish", "Chicken", "Pasta"};
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("Your choices are:");
		builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        })
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
			}
		});

		return builder.create();
	}
}
