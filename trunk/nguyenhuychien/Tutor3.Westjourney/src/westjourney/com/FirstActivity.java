package westjourney.com;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class FirstActivity extends Activity {
	private TextView txtInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		Log.d("Life-cycle", "On create activity");
		txtInfo = (TextView) findViewById(R.id.txtInfo);
	}

	@Override
	protected void onStart() {
		Log.d("Life-cycle", "On start activity");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		Log.d("Life-cycle", "On restart activity");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.d("Life-cycle", "On resume activity");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.d("Life-cycle", "On pause activity");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.d("Life-cycle", "On stop activity");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.d("Life-cycle", "On destroy activity");
		super.onDestroy();
	}

	public void testClick(View v) {
		// move second, intent
		Intent i2 = new Intent(
				FirstActivity.this,SecondActivity.class);
		startActivity(i2);
	}

	public void infoClick(View v) {
		// bunlde
		Bundle bundle = new Bundle();
		bundle.putString("welcome", "Welcome to Tay Luong");
		bundle.putInt("name", 18);

		Intent i2 = new Intent(FirstActivity.this, SecondActivity.class);

		i2.putExtras(bundle);
		// startActivity(i2);
		startActivityForResult(i2, Constant.REQUEST_FROM_1TO2);
	}

	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		if (requestCode == Constant.REQUEST_FROM_1TO2) {
			if (resultCode == Constant.BACK_FROM2TO1) {
				String name = intent.getStringExtra("name");
				int age = intent.getIntExtra("age", 0);

				// display
				txtInfo.setText("Infor\n" + "name: " + name + "\n" + "age: "
						+ age);
			}
		}
	}
}
