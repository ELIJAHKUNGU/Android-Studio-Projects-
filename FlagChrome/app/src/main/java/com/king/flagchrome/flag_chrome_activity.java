package com.king.flagchrome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;


public class flag_chrome_activity extends AppCompatActivity {
    //declare view var
    Toolbar mToolBar;
    ImageView mDisplayCountry;
    TextView mDisplayDeets;

    //image array
    int[] images = {R.drawable.afghanistan, R.drawable.argentina, R.drawable.brazil,
    R.drawable.iran,R.drawable.kenya, R.drawable.malawi, R.drawable.malaysia,R.drawable.sa,
    R.drawable.tanzania,R.drawable.uganda,R.drawable.uruguay,R.drawable.vietnam};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_chrome_activity);

        //assi var to view
        mToolBar = findViewById(R.id.toolbar2);
        mDisplayCountry = findViewById(R.id.imageView);
        mDisplayDeets = findViewById(R.id.textView2);

        Intent receive = getIntent();
        int position = receive.getIntExtra("pos", 0);

        //recive clicked item
        String tittle = getResources().getStringArray(R.array.countries)[position];
        mToolBar.setTitle(tittle);

        if (tittle.equalsIgnoreCase("Kenya")) {
            mDisplayCountry.setImageResource(images[position]);
            mDisplayDeets.setText("capital city: Nairobi");
        } else if (tittle.equalsIgnoreCase("Brazil")) {
            mDisplayCountry.setImageResource(images[position]);
            mDisplayDeets.setText("capital city: Rio");
        } else if (tittle.equalsIgnoreCase("Tanzania")) {
            mDisplayCountry.setImageResource(images[position]);
            mDisplayDeets.setText("capital city: Dodoma");
        }
    }}
