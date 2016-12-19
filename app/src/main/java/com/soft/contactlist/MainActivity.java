package com.soft.contactlist;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.soft.contactlist.db.service.UserService;
import static com.soft.contactlist.db.Resource.DB_NAME;

public class MainActivity extends AppCompatActivity {
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Contact List App");

        final ListView listView = (ListView) findViewById(R.id.contact_list);
        contactAdapter = new ContactAdapter(new UserService(this).getAll(), this);
        listView.setAdapter(contactAdapter);
        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User user = (User) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                intent.putExtra("user", user);
                startActivityForResult(intent, 2);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Menu");
        menu.add(1, 1, 1, "Delete");
        menu.add(1, 2, 1, "Edit");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:

                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                Toast.makeText(this, "Delete ", Toast.LENGTH_SHORT).show();
                //contactAdapter.deleteUser(info.position);
                new UserService(MainActivity.this).delete((User) contactAdapter.getItem(info.position));
                contactAdapter.invalidate();
                return true;
            case 2:
                AdapterView.AdapterContextMenuInfo edit = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                Toast.makeText(this, "Edit ", Toast.LENGTH_SHORT).show();

                return true;

            default:
                return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings:
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, 1);
                return true;
            case R.id.menu_clear:
                SQLiteDatabase.deleteDatabase(getDatabasePath(DB_NAME));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            /*String name = data.getStringExtra("name");
            String phone = data.getStringExtra("phone");
            int icon = data.getIntExtra("image", R.drawable.noicon);
            User user = new User(name, phone, icon);
            contactAdapter.addUser(user);*/
            contactAdapter.invalidate();
        }
        //super.onActivityResult(requestCode, resultCode, data);
    }
}
