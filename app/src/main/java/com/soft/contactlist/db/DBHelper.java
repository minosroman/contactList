package com.soft.contactlist.db;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.ContactsContract;
import android.widget.ListView;

import com.soft.contactlist.MainActivity;
import com.soft.contactlist.R;
import com.soft.contactlist.User;
import com.soft.contactlist.db.dao.UserDAO;
import com.soft.contactlist.db.service.UserService;

import java.util.ArrayList;

/**
 * Created by minos on 13.12.2016.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Activity activity) {
        super(activity, Resource.DB_NAME, null, Resource.DB_VER);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Resource.User.CREATE_TABLE);

        new UserDAO(sqLiteDatabase).save(new User("Goblin", "646-050-05-05", R.drawable.icon1));
        new UserDAO(sqLiteDatabase).save(new User("Ork", "321-123-222", R.drawable.icon2));
        new UserDAO(sqLiteDatabase).save(new User("Bandit", "102-102-02", R.drawable.icon3));
        new UserDAO(sqLiteDatabase).save(new User("Troll", "911-911-11", R.drawable.icon4));

        new UserDAO(sqLiteDatabase).save(new User("Troll", "911-911-11", R.drawable.icon4));


    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
