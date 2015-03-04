package esgi.fr.myaverage;


import esgi.fr.myaverage.db.MyAverageDbHelper;
import esgi.fr.myaverage.db.MyAverageContract.MyAverageDB;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TestActivity extends Activity {

	private int id_subject;
	private int id_mark;
	private String title_subject;
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
		
		Intent intent = getIntent();
		id_mark = Integer.parseInt(intent.getStringExtra("ID_MARK"));
		id_subject = Integer.parseInt(intent.getStringExtra("ID_SUBJECT"));
		title_subject = intent.getStringExtra("TITLE_SUBJECT");
		TextView subjectName = (TextView) findViewById(R.id.textViewSubjectName);
		subjectName.setText(title_subject);
		Log.i("SUBJECT",title_subject);
		EditText myMark = (EditText) findViewById(R.id.TestMark);
		EditText myMarkCoef = (EditText) findViewById(R.id.coefficient);
		myMark.setText(intent.getStringExtra("VALUE_MARK"));
		myMarkCoef.setText(intent.getStringExtra("COEF_MARK"));
		
		TextView save = (TextView) findViewById(R.id.saveMark);
		save.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				EditText myMark = (EditText) findViewById(R.id.TestMark);
				EditText myMarkCoef = (EditText) findViewById(R.id.coefficient);
				String mark = myMark.getText().toString();
				Log.i("MARK",mark);
				String coef = myMarkCoef.getText().toString();
				Log.i("COEF",coef);
				if(MainActivity.isNumeric(coef))
				{
					Context newContext = TestActivity.this;
					MyAverageDbHelper mDbHelper = new MyAverageDbHelper(newContext);
					SQLiteDatabase db = mDbHelper.getWritableDatabase();
					
					// Create a new map of values, where column names are the keys
					ContentValues values = new ContentValues();
					values.put(MyAverageDB.COLUMN_NAME_MARK_ID, id_mark);
					values.put(MyAverageDB.COLUMN_NAME_MARK_VALUE, mark);
					values.put(MyAverageDB.COLUMN_NAME_MARK_COEF, coef);
					values.put(MyAverageDB.COLUMN_NAME_SUBJECT_ID, id_subject);

					// Insert the new row, returning the primary key value of the new row
					long newRowId;
					newRowId = db.insert(
							MyAverageDB.TABLE_MARKS,
							MyAverageDB.COLUMN_NAME_MARK_VALUE,
					         values);
					
					
					SQLiteDatabase db2 = mDbHelper.getReadableDatabase();


		        	// Which row to update, based on the ID
		        	String selection = MyAverageDB.COLUMN_NAME_MARK_ID + " LIKE ?";
		        	String[] selectionArgs = { String.valueOf(id_mark) };

		        	int count = db2.update(
		        			MyAverageDB.TABLE_MARKS,
		        	    values,
		        	    selection,
		        	    selectionArgs);
					// Renvoie à l'ecran principal
					Intent i = new Intent(TestActivity.this, MainActivity.class);
					startActivity(i);
				}
				else
					Toast.makeText(getApplicationContext(), "Un coefficient est forcement numérique !", Toast.LENGTH_LONG).show();
				
				
			}
			
		});
		
		TextView delete = (TextView) findViewById(R.id.deleteMark);
		delete.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// Supprimer la matère
				Context newContext = TestActivity.this;
				MyAverageDbHelper mDbHelper = new MyAverageDbHelper(newContext);
				SQLiteDatabase db = mDbHelper.getWritableDatabase();
				
				// Define 'where' part of query.
				String selection = MyAverageDB.COLUMN_NAME_MARK_ID + " LIKE ?";
				// Specify arguments in placeholder order.
				String[] selectionArgs = { String.valueOf(id_mark) };
				// Issue SQL statement.
				db.delete(MyAverageDB.TABLE_MARKS, selection, selectionArgs);
				
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
