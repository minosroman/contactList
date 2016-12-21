package com.soft.contactlist;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class SplashActivity extends AppCompatActivity {
    final Handler spHand = new Handler();
    final SplashHandler sp = new SplashHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        spHand.postDelayed(sp, 3000);
        findViewById(R.id.activity_splash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.run();
                spHand.removeCallbacks(sp);
            }
        });
    }

    class SplashHandler implements Runnable {
        public void run() {
            startActivity(new Intent(getApplication(), MainActivity.class));
            finish();
        }
    }
}