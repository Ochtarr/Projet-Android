package esgi.fr.myaverage;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import esgi.fr.myaverage.db.MyAverageContract.MyAverageDB;
import esgi.fr.myaverage.db.MyAverageDbHelper;
import esgi.fr.myaverage.models.Promotion;
import esgi.fr.myaverage.models.Subject;

public class MainActivity extends Activity {

	 private Promotion myPromo = new Promotion("myPromo");
	 public final static String SUBJECT = "SUBJECT";
	 public final static String ID_SUBJECT = "ID_SUBJECT";
	 private int nb_subjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Typeface font = Typeface.createFromAsset(getAssets(), "Lobster_1.4.otf");
        TextView tv=(TextView) findViewById(R.id.textViewTitle);
        tv.setTypeface(font);
		Context newContext = this;
		MyAverageDbHelper mDbHelper = new MyAverageDbHelper(newContext);
		SQLiteDatabase db = mDbHelper.getReadableDatabase();
		// Define a projection that specifies which columns from the database
		// you will actually use after this query.
		String[] projectionMarks = {
				MyAverageDB.COLUMN_NAME_MARK_ID,
				MyAverageDB.COLUMN_NAME_MARK_VALUE,
				MyAverageDB.COLUMN_NAME_MARK_COEF,
				MyAverageDB.COLUMN_NAME_MARK_SUBJECT_ID,
		};
		String[] projectionSubjects = {
				MyAverageDB.COLUMN_NAME_SUBJECT_ID,
				MyAverageDB.COLUMN_NAME_SUBJECT_NAME,
				MyAverageDB.COLUMN_NAME_SUBJECT_COEF,
		};
		// How you want the results sorted in the resulting Cursor
		String sortOrderMarks = MyAverageDB.COLUMN_NAME_MARK_ID + " DESC";
		String sortOrderSubjects = MyAverageDB.COLUMN_NAME_SUBJECT_ID + " DESC";
		
		Cursor cursorSubjects = db.query(MyAverageDB.TABLE_SUBJECTS, // The table to query
				projectionSubjects, // The columns to return
				null, // The columns for the WHERE clause
				null, // The values for the WHERE clause
				null, // don't group the rows
				null, // don't filter by row groups
				sortOrderSubjects // The sort order
				);
		nb_subjects = cursorSubjects.getCount();
		cursorSubjects.moveToFirst();
		while(!cursorSubjects.isAfterLast())
		{
			int subjectId = cursorSubjects.getInt(
					cursorSubjects.getColumnIndexOrThrow(MyAverageDB.COLUMN_NAME_SUBJECT_ID)
				);
			String subjectTitle = cursorSubjects.getString(
					cursorSubjects.getColumnIndexOrThrow(MyAverageDB.COLUMN_NAME_SUBJECT_NAME)
				);
			String subjectCoef = cursorSubjects.getString(
					cursorSubjects.getColumnIndexOrThrow(MyAverageDB.COLUMN_NAME_SUBJECT_COEF)
				);
			if(isNumeric(subjectCoef))
				myPromo.setSubject(new Subject(subjectId, subjectTitle, Double.parseDouble(subjectCoef)));
			cursorSubjects.moveToNext();
		}
		if (!myPromo.getListSubjects().isEmpty()) {
			Cursor cursorMarks = db.query(MyAverageDB.TABLE_MARKS, // The table
																	// to query
					projectionMarks, // The columns to return
					null, // The columns for the WHERE clause
					null, // The values for the WHERE clause
					null, // don't group the rows
					null, // don't filter by row groups
					sortOrderMarks // The sort order
					);
			cursorMarks.moveToFirst();
			while (!cursorMarks.isAfterLast()) {
				int markId = cursorMarks
						.getInt(cursorMarks
								.getColumnIndexOrThrow(MyAverageDB.COLUMN_NAME_MARK_ID));
				String markValue = cursorMarks
						.getString(cursorMarks
								.getColumnIndexOrThrow(MyAverageDB.COLUMN_NAME_MARK_VALUE));
				String markCoef = cursorMarks
						.getString(cursorMarks
								.getColumnIndexOrThrow(MyAverageDB.COLUMN_NAME_MARK_COEF));
				String markSubjectID = cursorMarks
						.getString(cursorMarks
								.getColumnIndexOrThrow(MyAverageDB.COLUMN_NAME_SUBJECT_ID));
				int markID = Integer.parseInt(markSubjectID);
				for (int i = 0; i < myPromo.getListSubjects().size(); i++) {
					if (markID == myPromo.getListSubjects().get(i).getId()) {
						myPromo.getListSubjects()
								.get(i)
								.setTest(markId, "", "", Double.parseDouble(markValue),
										Double.parseDouble(markCoef));
					}
				}
				cursorMarks.moveToNext();
			}
		}
		
		Double globalAverage = myPromo.getGlobalAverage();
		if (globalAverage > 1.f) {
			TextView globalMark = (TextView) findViewById(R.id.textViewGlobalAverage);
			globalMark.setText(new String("" + globalAverage));
		}
		ArrayList<String> listSubjects = new ArrayList<String>();
		for (int i = myPromo.getListSubjects().size()-1; i >= 0; i--)
			listSubjects.add(myPromo.getListSubjects().get(i).getName());
		ListView lv = (ListView) findViewById(R.id.listViewSubject);
		ArrayAdapter adapter=new ArrayAdapter<String>(this,
	            android.R.layout.simple_list_item_1,
	            listSubjects);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	        public void onItemClick(AdapterView<?> av, View view, int i, long l) {
	            Intent in = new Intent(MainActivity.this,SubjectActivity.class);
				in.putExtra(SUBJECT, "YES");
				in.putExtra(ID_SUBJECT,new String(""+myPromo.getListSubjects().get(nb_subjects-i-1).getId()));
				in.putExtra("TITLE_SUBJECT",myPromo.getListSubjects().get(nb_subjects-i-1).getName());
				in.putExtra("COEF_SUBJECT",new String(""+myPromo.getListSubjects().get(nb_subjects-i-1).getCoefficient()));
				in.putExtra("AVERAGE_SUBJECT",new String(""+myPromo.getListSubjects().get(nb_subjects-i-1).getAverage()));
				startActivity(in);
	        }
	    });
		
		if(nb_subjects<2)
		{
			ImageView iv = (ImageView) findViewById(R.id.superAndroid);
			iv.setVisibility(View.VISIBLE);
		}
		Button addSubject = (Button) findViewById(R.id.button_addSubject);
		addSubject.setOnClickListener(new View.OnClickListener(){
		
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this,SubjectActivity.class);
				i.putExtra(SUBJECT, "NONE");
				if(myPromo.getListSubjects().isEmpty())
					i.putExtra(ID_SUBJECT,new String("1"));
				else
					i.putExtra(ID_SUBJECT,new String(""+(getMaxId(myPromo.getListSubjects())+1)));
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public static boolean isNumeric(String str)  
    {  
      try  
      {  
        double d = Double.parseDouble(str);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }
    
    public int getMaxId(ArrayList<Subject> array)
    {
    	int max = 0;
    	for(int i = 0; i < array.size() ; i++)
    		if(max < array.get(i).getId())
    			max = array.get(i).getId();
    	return max;
    }
}
