package com.toneloc.sequels;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by t on 6/22/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1; //change as we upgrade
    public static final String DB_NAME = "ReallyBadSequels.db"; //name of your db
    public static final String CREATE_TABLE = "CREATE TABLE sequels (id INT PRIMARY KEY, name TEXT);";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS sequels;";


    public DatabaseHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    //NOT an override
    public void seedDatabase() {
        insertSequel(1, "Empire Strikes Back");
        insertSequel(2, "Toy Story 2");
        insertSequel(3, "Halloween 2");
        insertSequel(4, "Mulan 2");
        insertSequel(5, "Taken 2");
        insertSequel(6, "Deathwish 2");
        insertSequel(7, "Zoolander 2");
    }

    public void insertSequel(int id, String name) {
        //INSERT INTO table_name VALUES (
        SQLiteDatabase db = getReadableDatabase();
        //special type of hash map for Database values
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", id);
        //protip -- great place to put a breakpoint to see what's up
        //insert into table null values
        db.insert("sequels", null, values);
    }
}
