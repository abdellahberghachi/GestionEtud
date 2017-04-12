package com.abdo.gestionetu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 05/03/2016.
 */
public class MaBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "student.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_SQL = "CREATE TABLE Student (" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "NOM TEXT, " +
            "EMAIL TEXT, " +
            "AGE INTEGER);";
    private static final String DROP_SQL = "DROP TABLE IF EXISTS ETUDIANT;";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_SQL);
        onCreate(db);
    }

    public MaBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
