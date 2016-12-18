package com.soft.contactlist.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import com.soft.contactlist.User;
import com.soft.contactlist.db.Resource;
import com.soft.contactlist.db.dao.core.DAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minos on 13.12.2016.
 */

public class UserDAO implements DAO<User> {

    private SQLiteDatabase sqLiteDatabase;

    public UserDAO(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }

    private ContentValues setUser(User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Resource.User.NAME, user.getName());
        contentValues.put(Resource.User.PHONE, user.getPhone());
        contentValues.put(Resource.User.ICON, user.getImageView());
        return contentValues;
    }

    private ContentValues delUser(User user) {
        ContentValues contentValues = new ContentValues();
        return contentValues;
    }


    public void delete(User user) {
        sqLiteDatabase.delete(Resource.User.TABLE_NAME, Resource.User.ID + " = ?", new String[]{String.valueOf(user.getId())});
    }

    public void update(User user) {
        sqLiteDatabase.update(Resource.User.TABLE_NAME, setUser(user), Resource.User.ID + " = ?", new String[]{String.valueOf(user.getId())});
    }

    @Override
    public long save(User user) {
        return sqLiteDatabase.insert(Resource.User.TABLE_NAME, null, setUser(user));
    }

    @Override
    public List<User> getAll() {
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + Resource.User.TABLE_NAME, null);
        return parseCursor(cursor);
    }

    @Override
    public List<User> parseCursor(Cursor cursor) {
        List<User> users = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndex(Resource.User.ID));
                String name = cursor.getString(cursor.getColumnIndex(Resource.User.NAME));
                String phone = cursor.getString(cursor.getColumnIndex(Resource.User.PHONE));
                int icon = cursor.getInt(cursor.getColumnIndex(Resource.User.ICON));
                users.add(new User(id, name, phone, icon));
            } while (cursor.moveToNext());
        }
        return users;
    }
}
