package fr.esgi.android.tdactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * EXO 7
 * @author odenier
 *
 */
public class DialogActivity extends Activity {

	private static final String TAG = "DialogActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.v(TAG, "onCreate");

		setContentView(R.layout.activity_dialog);
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
