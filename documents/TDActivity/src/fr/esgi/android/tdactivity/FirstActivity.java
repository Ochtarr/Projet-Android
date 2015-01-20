package fr.esgi.android.tdactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * EXO 6
 * @author odenier
 *
 */
public class FirstActivity extends Activity {

	private static final String TAG = "FirstActivity";

	private static final int REQUEST_CODE = 123;

	public static final String INPUT = "INPUT";

	TextView myText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.v(TAG, "onCreate");

		setContentView(R.layout.activity_first);

		myText = (TextView) findViewById(R.id.my_text);
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

	public void launchSecondActivityForResult(View view) {
		// On créé un Intent poiur lancer une Activity dont on souhaite récupérer un résultat 
		Intent intent = new Intent(this, SecondActivity.class);
		startActivityForResult(intent, REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.v(TAG, "onActivityResult");

		// On récupère le résultat renvoyé par SecondActivity
		if (requestCode == REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				// On passe ici si on a quitté SecondActivity en validant notre saisie à l'aide du bouton OK
				Log.v(TAG, "Result OK");

				myText.setText(data.getStringExtra(INPUT));
			}
			else if (resultCode == RESULT_CANCELED) {
				// On passe ici si on a quitté SecondActivity via le BACK 
				Log.v(TAG, "Result CANCELED");
				
				myText.setText("");
			}
		}
	}

}
