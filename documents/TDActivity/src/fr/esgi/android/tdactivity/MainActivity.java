package fr.esgi.android.tdactivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;

/**
 * EXO 1 - EXO 2 - EXO 5 - EXO 7
 * @author odenier
 * 
 */
public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";

	Chronometer chrono;

	private long delay = 0l;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.v(TAG, "onCreate");

		setContentView(R.layout.activity_main);

		chrono = (Chronometer) findViewById(R.id.chrono);
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

		// On démarre l'activity OtherActivity (Code à décommenter pour l'EXO 2)
		Intent intent = new Intent(this, OtherActivity.class);
		startActivity(intent);

		delay = SystemClock.elapsedRealtime() - chrono.getBase();
		chrono.stop();
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

	/**
	 * Méthode déclenchée sur le click du bouton CALL (EXO 5)
	 * @param view
	 */
	public void launchCallActivity(View view) {
		String url = "tel:1234567890";
		Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
		startActivity(intent);

//		ActivityOptions options = ActivityOptions.makeScaleUpAnimation(view, 0, 0, view.getWidth(), view.getHeight());
//		ActivityOptions options = ActivityOptions.makeCustomAnimation(this, enterResId, exitResId);
//		Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
//		ActivityOptions options = ActivityOptions.makeThumbnailScaleUpAnimation(view, bm, 0, 0);
//		startActivity(intent, options.toBundle());
	}

	/**
	 * Méthode déclenchée sur le click du bouton Dialog (EXO 7)
	 * @param view
	 */
	public void launchDialogActivity(View view) {
		chrono.setBase(SystemClock.elapsedRealtime() - delay);
		chrono.start();

		Intent intent = new Intent(this, DialogActivity.class);
		startActivity(intent);
	}
}
