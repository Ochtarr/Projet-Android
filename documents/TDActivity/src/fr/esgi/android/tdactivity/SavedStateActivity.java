package fr.esgi.android.tdactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * EXO 3
 * @author odenier
 *
 */
public class SavedStateActivity extends Activity {

	private static final String TAG = "SavedStateActivity";

	private static final String KEY_MA_VARIABLE = "KEY_MA_VARIABLE";
	public int maVariable = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_savedstate);

		Log.v(TAG, "onCreate");
	}

	@Override
	protected void onStart() {
		super.onStart();

		Log.v(TAG, "onStart-maVariable: " + maVariable);
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		Log.v(TAG, "onResume-maVariable: " + maVariable);
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.v(TAG, "onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.v(TAG, "onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.v(TAG, "onDestroy");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		Log.v(TAG, "onSaveInstanceState");

		// Je modifie la valeur de ma variable et la mémorise dans l'état de l'Activity
		maVariable = 10;
		outState.putInt(KEY_MA_VARIABLE, maVariable);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

		// On ne passe dans cette méthode que si la méthode onSaveInstanceState avait préalablement été appelée !
		Log.v(TAG, "onRestoreInstanceState");

		// Je recharge maVariable préalablement sauvegardée dans l'état de l'Activity
		maVariable = savedInstanceState.getInt(KEY_MA_VARIABLE);
	}

}
