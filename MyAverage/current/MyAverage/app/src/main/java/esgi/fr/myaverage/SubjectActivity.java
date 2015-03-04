package esgi.fr.myaverage;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import esgi.fr.myaverage.db.MyAverageContract.MyAverageDB;
import esgi.fr.myaverage.db.MyAverageDbHelper;


public class SubjectActivity extends Activity {
	 public final static String SUBJECT = "SUBJECT";
	 public final static String ID_SUBJECT = "ID_SUBJECT";
	 private int id_subject;
	 private String title_subject;
	 private String coef_subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subject);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "Lobster_1.4.otf");
        TextView tv=(TextView) findViewById(R.id.textViewTitle_activity2);
        tv.setTypeface(font);
        
		Intent intent = getIntent();
		String subject = intent.getStringExtra(SUBJECT);
		id_subject = Integer.parseInt(intent.getStringExtra(ID_SUBJECT));
		// Si l'utilisateur a cliqué sur une matiere on charge les notes
		if (!subject.equals("NONE")) {
			EditText title_tf = (EditText) findViewById(R.id.subjectName);
	        EditText coef_tf = (EditText) findViewById(R.id.subjectCoefficient);
	        title_tf.setText(intent.getStringExtra("TITLE_SUBJECT"));
	        coef_tf.setText(intent.getStringExtra("COEF_SUBJECT"));
		}

		TextView delete = (TextView) findViewById(R.id.delete);

		delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Supprimer la matère
				Context newContext = SubjectActivity.this;
				MyAverageDbHelper mDbHelper = new MyAverageDbHelper(newContext);
				SQLiteDatabase db = mDbHelper.getWritableDatabase();
				
				// Define 'where' part of query.
				String selection = MyAverageDB.COLUMN_NAME_SUBJECT_ID + " LIKE ?";
				// Specify arguments in placeholder order.
				String[] selectionArgs = { String.valueOf(id_subject) };
				// Issue SQL statement.
				db.delete(MyAverageDB.TABLE_SUBJECTS, selection, selectionArgs);
				
				// Renvoie à l'ecran principal
				Intent i = new Intent(SubjectActivity.this, MainActivity.class);
				startActivity(i);
			}

		});
		TextView save = (TextView) findViewById(R.id.save);
		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//Recupere le nom et le coef
				EditText title_tf = (EditText) findViewById(R.id.subjectName);
		        EditText coef_tf = (EditText) findViewById(R.id.subjectCoefficient);
		        title_subject = title_tf.getText().toString();
		        coef_subject = coef_tf.getText().toString();
				// Sauvegarder la matère
				Context newContext = SubjectActivity.this;
				MyAverageDbHelper mDbHelper = new MyAverageDbHelper(newContext);
				SQLiteDatabase db = mDbHelper.getWritableDatabase();

				// Create a new map of values, where column names are the keys
				ContentValues values = new ContentValues();
				values.put(MyAverageDB.COLUMN_NAME_SUBJECT_ID, id_subject);
				values.put(MyAverageDB.COLUMN_NAME_SUBJECT_NAME, title_subject);
				values.put(MyAverageDB.COLUMN_NAME_SUBJECT_COEF, coef_subject);

				// Insert the new row, returning the primary key value of the new row
				long newRowId;
				newRowId = db.insert(
						MyAverageDB.TABLE_SUBJECTS,
						MyAverageDB.COLUMN_NAME_SUBJECT_NAME,
				         values);

				// Renvoie à l'ecran principal
				Intent i = new Intent(SubjectActivity.this, MainActivity.class);
				startActivity(i);
			}

		});
		TextView title = (TextView) findViewById(R.id.textViewTitle_activity2);
		title.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Renvoie à l'ecran principal
				Intent i = new Intent(SubjectActivity.this, MainActivity.class);
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
