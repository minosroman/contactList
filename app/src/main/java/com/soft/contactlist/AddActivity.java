package com.soft.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.soft.contactlist.db.service.UserService;

public class AddActivity extends AppCompatActivity {
    EditText phone;
    EditText name;
    ImageView image;
    int sImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_applications);
        phone = (EditText) findViewById(R.id.addPhone);
        name = (EditText) findViewById(R.id.changeName);
        image = (ImageView) findViewById(R.id.addImage);


        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sName = name.getText().toString();
                String sPhone = phone.getText().toString();
                Intent intent = new Intent();
                /*intent.putExtra("name", sName);
                intent.putExtra("phone", sPhone);
                intent.putExtra("image", sImage);*/
                User user = new User(sName, sPhone, sImage);
                new UserService(AddActivity.this).save(user);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        findViewById(R.id.selectImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("file*//*");
                startActivity(intent);

                sImage = R.drawable.icon7;
                image.setImageResource(sImage);
            }
        });

    }
}
