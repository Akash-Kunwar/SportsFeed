package com.company.dell_pc.football;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by DELL-PC on 1/26/2019.
 */

public class databasehelper extends SQLiteOpenHelper {
   Context context;
    private static final String db_Name="drink";
    private static final int db_version=1;
    public databasehelper(Context context)
    {
        super(context,db_Name,null,db_version);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
