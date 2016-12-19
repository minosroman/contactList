package com.soft.contactlist;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        runMain();

    }
    class SplashHandler implements Runnable {
        public void run() {
            startActivity(new Intent(getApplication(), MainActivity.class));
            finish();
        }
    }
    private void runMain() {
        Handler splashNew = new Handler();
        splashNew.postDelayed(new SplashHandler(), 3000);

    }
}
