package com.soft.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.soft.contactlist.db.Resource;
import com.soft.contactlist.db.service.UserService;

public class UpdateActivity extends AppCompatActivity {
    EditText phone;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        name = (EditText) findViewById(R.id.addPhone);
        phone = (EditText) findViewById(R.id.changeName);
        final User user = getIntent().getParcelableExtra("user");
        name.setText(user.getName());
        phone.setText(user.getPhone());

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eName = name.getText().toString();
                String ePhone = phone.getText().toString();
                user.setName(eName);
                user.setPhone(ePhone);
                new UserService(UpdateActivity.this).update(user);
                setResult(RESULT_OK, new Intent());
                finish();
            }
        });
    }
}
