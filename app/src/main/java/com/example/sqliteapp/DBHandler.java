package com.example.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "database";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String NAMA_TABLE = "dataMhs";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String NAMA_COL = "nama";

    // below variable id for our course duration column.
    private static final String NIM_COL = "nim";

    // below variable for our course description column.
    private static final String JURUSAN_COL = "jurusan";

    // below variable is for our course tracks column.
    private static final String FAKULTAS_COL = "fakultas";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + NAMA_TABLE + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAMA_COL + " TEXT,"
                + NIM_COL + " TEXT,"
                + JURUSAN_COL + " TEXT,"
                + FAKULTAS_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewCourse(String courseNama, String courseNim, String courseJurusan, String courseFakultas) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAMA_COL, courseNama);
        values.put(NIM_COL, courseNim);
        values.put(JURUSAN_COL, courseJurusan);
        values.put(FAKULTAS_COL, courseFakultas);

        // after adding all values we are passing
        // content values to our table.
        db.insert(NAMA_TABLE, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABLE);
        onCreate(db);
    }
}
