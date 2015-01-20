package fr.esgi.android.tdactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * EXO 4
 * @author odenier
 *
 */
public class FormActivity extends Activity {

	private static final String TAG = "FormActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/*
		 Le layout activity_form.xml contient un champ de saisie EditText
		 Saisissez quelque chose et retournez votre device (CTRL+F11 avec l'émulateur)
				=> l'activity est détruite et réinstanciée
		 		=> la valeur saisie est conservée car sauvegardée et rechargée automatiquement par le système
		 Enlevez la déclaration "android:id" du composant EditText et refaites l'opération
		 		=> la valeur saisie n'est plus automatiquement conservée, la valeur saisie est perdue :(
		 */		 		 
		setContentView(R.layout.activity_form);

		Log.v(TAG, "onCreate");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		Log.v(TAG, "onDestroy");
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
