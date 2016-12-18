package com.soft.contactlist.db.service.core;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;

import com.soft.contactlist.db.DBHelper;

/**
 * Created by minos on 13.12.2016.
 */

public class OpenDBService {
    private DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }

    protected boolean isOpen(){
        return sqLiteDatabase != null && dbHelper != null && sqLiteDatabase.isOpen();
    }
    protected void open(Activity activity){
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()){
            dbHelper = new DBHelper(activity);
            sqLiteDatabase = dbHelper.getWritableDatabase();
        }
    }
    protected void close(){
        if(dbHelper != null){
            dbHelper.close();
        }
    }
}
