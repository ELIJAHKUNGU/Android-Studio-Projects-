package com.king.camerawithsplash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    //declare var
    ImageView mWelcomeImg;
    ProgressBar mLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //assign
        mWelcomeImg = findViewById(R.id.welcome);
        mLoad = findViewById(R.id.progressBar);

        Thread splash = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        splash.start();

    }
}
