package fr.esgi.android.tdactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * EXO 6
 * @author odenier
 * 
 */
public class SecondActivity extends Activity {

	private static final String TAG = "SecondActivity";

	EditText myInput;
	Button myButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.v(TAG, "onCreate");

		setContentView(R.layout.activity_second);

		myInput = (EditText) findViewById(R.id.my_input);

		myButton = (Button) findViewById(R.id.my_button);
		myButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// On arrête l'Activity en renvoyant à son Activity appelante (FirstActivity dans notre exemple) un résultat à l'aide d'un Intent
				Intent data = new Intent();
				data.putExtra(FirstActivity.INPUT, myInput.getText().toString());
				setResult(RESULT_OK, data);
				finish();
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		Log.v(TAG, "onDestroy");
	}

	@Override
	protected void onRestart() {
		super.onStart();

		Log.v(TAG, "onRestart");
	}

	@Override
	protected void onStart() {
		super.onStart();

		Log.v(TAG, "onStart");
	}

	@Override
	protected void onStop() {
		super.onStop();

		Log.v(TAG, "onStop");
	}

	@Override
	protected void onResume() {
		super.onResume();

		Log.v(TAG, "onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();

		Log.v(TAG, "onPause");
	}
}
