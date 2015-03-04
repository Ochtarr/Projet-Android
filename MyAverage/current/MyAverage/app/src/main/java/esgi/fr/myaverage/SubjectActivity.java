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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import esgi.fr.myaverage.db.MyAverageContract.MyAverageDB;
import esgi.fr.myaverage.db.MyAverageDbHelper;


public class SubjectActivity extends Activity {
	 public final static String SUBJECT = "SUBJECT";
	 public final static String ID_SUBJECT = "ID_SUBJECT";
	 private int id_subject;
	 private String title_subject;
	 private String coef_subject;
	 private Double my_moy;
	 private String subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subject);
		 
		Intent intent = getIntent();
		subject = intent.getStringExtra(SUBJECT);
		id_subject = Integer.parseInt(intent.getStringExtra(ID_SUBJECT));
		
		
		
		Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
		b1 = (Button) findViewById(R.id.button_mark1);
		b2 = (Button) findViewById(R.id.button_mark2);
		b3 = (Button) findViewById(R.id.button_mark3);
		b4 = (Button) findViewById(R.id.button_mark4);
		b5 = (Button) findViewById(R.id.button_mark5);
		b6 = (Button) findViewById(R.id.button_mark6);
		b7 = (Button) findViewById(R.id.button_mark7);
		b8 = (Button) findViewById(R.id.button_mark8);
		b9 = (Button) findViewById(R.id.button_mark9);
		b10 = (Button) findViewById(R.id.button_mark10);
		b11 = (Button) findViewById(R.id.button_mark11);
		b12 = (Button) findViewById(R.id.button_mark12);
		b13 = (Button) findViewById(R.id.button_mark13);
		b14 = (Button) findViewById(R.id.button_mark14);
		b15 = (Button) findViewById(R.id.button_mark15);
		b16 = (Button) findViewById(R.id.button_mark16);
		MarksListener ml = new MarksListener(id_subject);
		
		b1.setOnClickListener(ml);
		b2.setOnClickListener(ml);
		b3.setOnClickListener(ml);
		b4.setOnClickListener(ml);
		b5.setOnClickListener(ml);
		b6.setOnClickListener(ml);
		b7.setOnClickListener(ml);
		b8.setOnClickListener(ml);
		b9 .setOnClickListener(ml);
		b10.setOnClickListener(ml);
		b11.setOnClickListener(ml);
		b12.setOnClickListener(ml);
		b13.setOnClickListener(ml);
		b14.setOnClickListener(ml);
		b15.setOnClickListener(ml);
		b16.setOnClickListener(ml);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "Lobster_1.4.otf");
        TextView tv=(TextView) findViewById(R.id.textViewTitle_activity2);
        tv.setTypeface(font);
        
        
       
		
		TextView average=(TextView) findViewById(R.id.textViewSubjectAverage);
        average.setText(intent.getStringExtra("AVERAGE_SUBJECT"));
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
		        Context newContext = SubjectActivity.this;
				MyAverageDbHelper mDbHelper = new MyAverageDbHelper(newContext);
				
				if(MainActivity.isNumeric(coef_subject))
				{
					//Update la matiere
			        if (!subject.equals("NONE"))
			        {
			        	SQLiteDatabase db = mDbHelper.getReadableDatabase();

			        	// New value for one column
			        	ContentValues values = new ContentValues();
						values.put(MyAverageDB.COLUMN_NAME_SUBJECT_ID, id_subject);
						values.put(MyAverageDB.COLUMN_NAME_SUBJECT_NAME, title_subject);
						values.put(MyAverageDB.COLUMN_NAME_SUBJECT_COEF, coef_subject);

			        	// Which row to update, based on the ID
			        	String selection = MyAverageDB.COLUMN_NAME_SUBJECT_ID + " LIKE ?";
			        	String[] selectionArgs = { String.valueOf(id_subject) };

			        	int count = db.update(
			        			MyAverageDB.TABLE_SUBJECTS,
			        	    values,
			        	    selection,
			        	    selectionArgs);
			        }
			        // Inserer la matère
			        else 
			        {
			        
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
			        }
					

					// Renvoie à l'ecran principal
					Intent i = new Intent(SubjectActivity.this, MainActivity.class);
					startActivity(i);
				}
				else
					Toast.makeText(getApplicationContext(), "Un coefficient est forcement numérique !", Toast.LENGTH_LONG).show();
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
