package com.soft.contactlist.db;

import com.soft.contactlist.R;

/**
 * Created by minos on 13.12.2016.
 */

public class Resource {
    public static final String DB_NAME = "db_adapter_user";
    public static final int DB_VER = 1;

    public static final class User {
        public static final String ID = "id";
        public static final String ICON = "icon";
        public static final String NAME = "name";
        public static final String PHONE = "phone";
        public static final String TABLE_NAME = "users";


        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME + " TEXT(255), " + PHONE + " TEXT(255), " + ICON + " TEXT(255));";
    }
}
