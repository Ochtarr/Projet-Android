package esgi.fr.myaverage.db;

import android.provider.BaseColumns;

public final class MyAverageContract {
	// To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public MyAverageContract() {}

    /* Inner class that defines the table contents */
    public static abstract class MyAverageDB implements BaseColumns {
        public static final String TABLE_SUBJECTS = "subjects";
        public static final String COLUMN_NAME_SUBJECT_ID = "subjectid";
        public static final String COLUMN_NAME_SUBJECT_NAME = "subjectname";
        public static final String COLUMN_NAME_SUBJECT_COEF = "subjectcoef";
        public static final String TABLE_MARKS = "notes";
        public static final String COLUMN_NAME_MARK_ID = "markid";
        public static final String COLUMN_NAME_MARK_VALUE = "markvalue";
        public static final String COLUMN_NAME_MARK_COEF = "markcoef";
        public static final String COLUMN_NAME_MARK_SUBJECT_ID = "subjectid";
    }
}
