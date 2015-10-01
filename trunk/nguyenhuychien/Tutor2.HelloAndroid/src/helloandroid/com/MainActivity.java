package helloandroid.com;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		 LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);

		TextView helloTxt = new TextView(this);
		helloTxt.setText("  Wellcome android world  ?");
		layout.addView(helloTxt);

		final EditText nameEdt = new EditText(this);
		nameEdt.setHint("Enter your name here: ");
		nameEdt.setWidth(200);
		nameEdt.setLines(1);
		nameEdt.setBackgroundResource(R.drawable.border);
		layout.addView(nameEdt);

		final TextView aboutTxt = new TextView(this);
		aboutTxt.setText("");
		layout.addView(aboutTxt);

		final ImageView chienImg = new ImageView(this);
		layout.addView(chienImg);
		
		nameEdt.setOnKeyListener(new View.OnKeyListener() {

			@Override
			public boolean onKey(View v, int KeyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction() == KeyEvent.ACTION_DOWN
						&& KeyCode == KeyEvent.KEYCODE_ENTER) {
					String name = nameEdt.getText().toString();
					aboutTxt.setText("Hello " + name
							+ ".I am Nguyen Huy Chien\nAnd this is my Avatar");
					nameEdt.setText("");
					chienImg.setImageResource(R.drawable.chien);
					

				}
				return false;
			}
		});
		setContentView(layout);
	}

}
