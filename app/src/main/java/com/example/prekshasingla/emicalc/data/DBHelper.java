package com.example.prekshasingla.emicalc.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by prekshasingla on 05/05/17.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "emi.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_EMI_TABLE = "CREATE TABLE " + Contract.EMIEntry.TABLE_NAME + " (" +
                Contract.EMIEntry.COLUMN_USERID + "  TEXT NOT NULL," +
                Contract.EMIEntry.COLUMN_PRINCIPALAMOUNT + " INTEGER, " +
                Contract.EMIEntry.COLUMN_TENURE + " INTEGER, " +
                Contract.EMIEntry.COLUMN_TIMESTAMP + " TEXT NOT NULL, " +
                " );";


        sqLiteDatabase.execSQL(SQL_CREATE_EMI_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.EMIEntry.TABLE_NAME);


        onCreate(sqLiteDatabase);
    }
}
