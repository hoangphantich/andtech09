package com.iziroi.n9xkun.flickrapp.dialog;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.iziroi.n9xkun.flickrapp.R;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */
@SuppressLint("NewApi")
public class AboutDialog extends DialogFragment {

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {

      }
    });

    builder.setTitle(R.string.menu_about);
    builder.setMessage(R.string.app_version_info);

    return builder.create();
  }
}
