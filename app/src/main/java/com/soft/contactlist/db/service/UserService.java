package com.soft.contactlist.db.service;

import android.app.Activity;

import com.soft.contactlist.User;
import com.soft.contactlist.db.dao.UserDAO;
import com.soft.contactlist.db.service.core.OpenDBService;
import com.soft.contactlist.db.service.core.Service;

import java.util.List;

/**
 * Created by minos on 13.12.2016.
 */

public class UserService extends OpenDBService implements Service<User> {
    private Activity activity;

    public UserService(Activity activity) {
        this.activity = activity;
    }

    @Override
    public long save(User user) {

        try {
            if (!isOpen()) {
                open(activity);
            }
            return new UserDAO(getSqLiteDatabase()).save(user);
        } finally {
            if (isOpen())
                close();
        }
    }

    @Override
    public List<User> getAll() {
        try {
            if (!isOpen()) {
                open(activity);
            }
            return new UserDAO(getSqLiteDatabase()).getAll();
        } finally {
            if (isOpen())
                close();
        }
    }

    public void delete(User user) {
        try {
            if (!isOpen()) {
                open(activity);
            }
            new UserDAO(getSqLiteDatabase()).delete(user);
        } finally {
            if (isOpen())
                close();
        }
    }

    public void update(User user) {
        try {
            if (!isOpen()) {
                open(activity);
            }
            new UserDAO(getSqLiteDatabase()).update(user);
        } finally {
            if (isOpen())
                close();
        }
    }
}
