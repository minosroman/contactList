package com.soft.contactlist;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.provider.MediaStore.Images.Media;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.soft.contactlist.db.service.UserService;

import java.io.FileNotFoundException;
import java.io.IOException;

public class UpdateActivity extends AppCompatActivity {
    EditText phone;
    EditText name;
    ImageView image;
    int sImage = R.drawable.icon6;
    int REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        setTitle("Update Your Contact");
        name = (EditText) findViewById(R.id.changeName);
        phone = (EditText) findViewById(R.id.addPhone);
        image = (ImageView) findViewById(R.id.addImage);

        final User user = getIntent().getParcelableExtra("user");
        name.setText(user.getName());
        phone.setText(user.getPhone());
        image.setImageResource(user.getImageView());


        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eName = name.getText().toString();
                String ePhone = phone.getText().toString();
                user.setName(eName);
                user.setPhone(ePhone);
                user.setImageView(sImage);
                new UserService(UpdateActivity.this).update(user);
                setResult(RESULT_OK, new Intent());
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
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType("image/*");
                startActivityForResult(i, REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        Bitmap img = null;
        if (requestCode == REQUEST && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            try {
                img = Media.getBitmap(getContentResolver(), selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            image.setImageBitmap(img);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
