package lab2.christ_color.com;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnCheckedChangeListener {
	private TextView txtviewBackgroundDisplay;
	private RadioGroup radgroupChangeBackground;
	RadioButton rbtRed,rbtGreen,rbtYellow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rbtRed =(RadioButton) findViewById(R.id.rbtRed);
		rbtGreen = (RadioButton) findViewById(R.id.rbtGreen);
		rbtYellow = (RadioButton) findViewById(R.id.rbtYellow);
		txtviewBackgroundDisplay = (TextView) findViewById(R.id.txt1);
		radgroupChangeBackground = (RadioGroup) findViewById(R.id.rdg);
		radgroupChangeBackground.setOnCheckedChangeListener(this);
	}

	public void btnRedClick(View v) {
		rbtRed.setChecked(true);
		txtviewBackgroundDisplay.setBackgroundColor(Color.RED);
		Toast.makeText(this, "you changed Red background!", Toast.LENGTH_SHORT)
				.show();
	}

	public void btnGreenClick(View v) {
		rbtGreen.setChecked(true);
		txtviewBackgroundDisplay.setBackgroundColor(Color.GREEN);
		Toast.makeText(this, "you changed Green background!",
				Toast.LENGTH_SHORT).show();
	}

	public void btnYellowClick(View v) {
		rbtYellow.setChecked(true);
		txtviewBackgroundDisplay.setBackgroundColor(Color.YELLOW);
		Toast.makeText(this, "you changed Yellow background!",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rbtRed:
			txtviewBackgroundDisplay.setBackgroundColor(Color.RED);
			Toast.makeText(this, "you changed Red background!",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.rbtGreen:
			txtviewBackgroundDisplay.setBackgroundColor(Color.GREEN);
			Toast.makeText(this, "you changed Green background!",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.rbtYellow:
			txtviewBackgroundDisplay.setBackgroundColor(Color.YELLOW);
			Toast.makeText(this, "you changed Yellow background!",
					Toast.LENGTH_SHORT).show();
			break;
		}
	}
}
