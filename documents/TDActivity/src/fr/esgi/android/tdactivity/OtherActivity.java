package fr.esgi.android.tdactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * EXO 2
 * @author odenier
 *
 */
public class OtherActivity extends Activity {

	private static final String TAG = "OtherActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_other);

		Log.v(TAG, "onCreate");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		Log.v(TAG, "onDestroy");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		
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
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		Log.v(TAG, "onSaveInstanceState");
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

		Log.v(TAG, "onRestoreInstanceState");
	}
	
}
