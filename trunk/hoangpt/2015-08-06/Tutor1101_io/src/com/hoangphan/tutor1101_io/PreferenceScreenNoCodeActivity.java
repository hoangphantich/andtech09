package com.hoangphan.tutor1101_io;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PreferenceScreenNoCodeActivity extends PreferenceActivity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);		
	}
}
