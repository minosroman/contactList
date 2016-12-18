package com.soft.contactlist;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

/**
 * Created by minos on 07.12.2016.
 */

public class User implements Parcelable {
    private String name;
    private String phone;
    private Integer imageView;
    private long id;

    public User(String name, String phone, Integer imageView) {
        this.name = name;
        this.phone = phone;
        this.imageView = imageView;
    }

    public User(long id, String name, String phone, Integer imageView) {
        this.name = name;
        this.phone = phone;
        this.imageView = imageView;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    protected User(Parcel in) {
        name = in.readString();
        phone = in.readString();
        imageView = in.readInt();
        id = in.readLong();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getImageView() {
        return imageView;
    }

    public void setImageView(int path) {
        this.imageView = path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(phone);
        parcel.writeInt(imageView);
        parcel.writeLong(id);
    }
}
