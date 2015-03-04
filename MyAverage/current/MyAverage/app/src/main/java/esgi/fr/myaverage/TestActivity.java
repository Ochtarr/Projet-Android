package esgi.fr.myaverage;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        
        Typeface font = Typeface.createFromAsset(getAssets(), "Lobster_1.4.otf");
        TextView tv=(TextView) findViewById(R.id.textViewTitle_activity3);
        tv.setTypeface(font);
        
        TextView title = (TextView) findViewById(R.id.textViewTitle_activity3);
		title.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Renvoie à l'ecran principal
				Intent i = new Intent(TestActivity.this, MainActivity.class);
				startActivity(i);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
