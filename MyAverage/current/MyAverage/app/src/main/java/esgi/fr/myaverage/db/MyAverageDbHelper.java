package esgi.fr.myaverage.db;

import esgi.fr.myaverage.db.MyAverageContract.MyAverageDB;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class MyAverageDbHelper extends SQLiteOpenHelper {

	// If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "MyAverageDB.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_SUBJECTS =
        "CREATE TABLE " + MyAverageDB.TABLE_SUBJECTS + " (" +
        		MyAverageDB.COLUMN_NAME_SUBJECT_ID + " INTEGER PRIMARY KEY," +
		        MyAverageDB.COLUMN_NAME_SUBJECT_NAME + TEXT_TYPE + COMMA_SEP +
		        MyAverageDB.COLUMN_NAME_SUBJECT_COEF + TEXT_TYPE + 
        // Any other options for the CREATE command
        " )";
    private static final String SQL_CREATE_MARKS =
            "CREATE TABLE " + MyAverageDB.TABLE_MARKS + " (" +
            		MyAverageDB.COLUMN_NAME_MARK_ID + " INTEGER PRIMARY KEY," +
    		        MyAverageDB.COLUMN_NAME_MARK_VALUE + TEXT_TYPE + COMMA_SEP +
    		        MyAverageDB.COLUMN_NAME_MARK_COEF + TEXT_TYPE + COMMA_SEP +
    		        MyAverageDB.COLUMN_NAME_SUBJECT_ID + TEXT_TYPE +
            // Any other options for the CREATE command
            " )";

    private static final String SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS " + MyAverageDB.TABLE_SUBJECTS;
    
    
	    public MyAverageDbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
		

	   
	    public void onCreate(SQLiteDatabase db) {
	    	db.execSQL(SQL_CREATE_MARKS);
	        db.execSQL(SQL_CREATE_SUBJECTS);
	        
	    }
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        // This database is only a cache for online data, so its upgrade policy is
	        // to simply to discard the data and start over
	        db.execSQL(SQL_DELETE_ENTRIES);
	        onCreate(db);
	    }
	    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        onUpgrade(db, oldVersion, newVersion);
	    }
}

