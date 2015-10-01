package com.hoangphan.check03b_login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

@SuppressLint("NewApi")
public class SixEditText extends EditText {

	public SixEditText(Context context) {
		super(context);
	}
	
	public SixEditText(Context context, AttributeSet attrs, int defStyleAttr,
			int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	public SixEditText(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public SixEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
	}



	boolean validator(){
		Validator validator = new SixValidator();
		boolean result = validator.validator(this.getText().toString());
		
		if(!result){
			//shake input
		}
		
		return result;
	}

}
