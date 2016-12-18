package com.soft.contactlist;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.soft.contactlist.db.service.UserService;

import java.util.List;

/**
 * Created by minos on 07.12.2016.
 */

public class ContactAdapter extends BaseAdapter {
    private List<User> users;
    private LayoutInflater layoutInflater;
    private Activity activity;

    public ContactAdapter(List<User> users, Activity activity) {
        this.users = users;
        this.activity = activity;
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView name;
        TextView phone;
        ImageView imageView;
    }

    public void invalidate() {
        users = new UserService(activity).getAll();
        notifyDataSetChanged();
    }

    public void addUser(User user) {
        users.add(user);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.item_user, null, false);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imageView);
            viewHolder.name = (TextView) view.findViewById(R.id.name);
            viewHolder.phone = (TextView) view.findViewById(R.id.phone);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        User user = (User) getItem(position);
        viewHolder.imageView.setImageResource(user.getImageView());
        viewHolder.name.setText(user.getName());
        viewHolder.phone.setText(user.getPhone());
        return view;
    }
}
