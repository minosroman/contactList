package com.soft.contactlist.db.service.core;

import java.util.List;

/**
 * Created by minos on 13.12.2016.
 */

public interface Service<T> {
    long save(T t);

    List<T> getAll();
}
