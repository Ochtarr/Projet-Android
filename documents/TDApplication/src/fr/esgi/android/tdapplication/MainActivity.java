package fr.esgi.android.tdapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.v(TAG, "je passe dans onCreate de l'Activity");

		// Je récupère l'instance de ma classe Application et affiche sa variable membre publique "data"
		MonApplication app = (MonApplication) getApplication();
		Log.v(TAG, "application data: " + app.data);
		Log.v(TAG, "application method result: " + app.getResult());
	}
}
