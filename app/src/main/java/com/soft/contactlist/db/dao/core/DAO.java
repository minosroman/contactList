package com.soft.contactlist.db.dao.core;

import android.database.Cursor;

import java.util.List;

/**
 * Created by minos on 13.12.2016.
 */

public interface DAO<T> {
    long save(T t);

    List<T> getAll();

    List<T> parseCursor(Cursor cursor);

}
