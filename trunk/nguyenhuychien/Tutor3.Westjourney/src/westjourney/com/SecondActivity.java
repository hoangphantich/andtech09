package westjourney.com;



import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class SecondActivity extends Activity {
	private EditText nameTxt;
	private EditText ageTxt;
	private RadioButton rdMale;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		// init ui
		initUI();

		// get bundle
		Intent i21 = getIntent();
		Bundle bundle = i21.getExtras();
		String welcome = bundle.getString("welcome" );
		int number = bundle.getInt("name");

		// toaster
		_toaster(welcome);
		_toaster("This is " + number + " country");
	}

	private void initUI() {
		nameTxt = (EditText) findViewById(R.id.txtName);
		ageTxt = (EditText) findViewById(R.id.txtAge);
		rdMale = (RadioButton) findViewById(R.id.rdMale);

	}

	private void _toaster(String str) {
		Toast.makeText(SecondActivity.this, str, Toast.LENGTH_SHORT).show();
	}
	public void backFirst(View v){
		//put into bundle
		String name = nameTxt.getText().toString();
		int age = Integer.parseInt(ageTxt.getText().toString());
		boolean sex = true; //true is male
		if (!rdMale.isSelected()) {
			sex = false;
		}
		
		Bundle b = new Bundle();
		b.putString("name", name);
		b.putInt("age", age);
		
		//get Intent
		Intent i = getIntent(); //get intent from what activity
		i.putExtras(b);
		
		setResult(Constant.BACK_FROM2TO1, i);
		finish(); //destroy activity
	}
	
	public void gotoBagage(View v){
		//get information from ui
		String name = nameTxt.getText().toString();
		int age = Integer.parseInt(ageTxt.getText().toString());
		boolean sex = true; //true is male
		if (!rdMale.isSelected()) {
			sex = false;
		}
		
		Intent i3 = new Intent(SecondActivity.this, ThirdActivity.class);
		i3.putExtra("name", name);
		i3.putExtra("age", age);
		i3.putExtra("sex", sex);
		startActivityForResult(i3, Constant.REQUEST_FROM_2TO3);
	}

}
