package fr.esgi.android.tdapplication;

import android.app.Application;
import android.util.Log;

public class MonApplication extends Application {

	private static final String TAG = "MonApplication";

	private int result = 123;
	public String data = null;

	@Override
	public void onCreate() {
		super.onCreate();

		Log.v(TAG, "je passe dans onCreate de l'Application");

		// Affectation de ma variable d'instance
		data = "ma variable est initialisée";
	}

	public int getResult() {
		return result;
	}

}
