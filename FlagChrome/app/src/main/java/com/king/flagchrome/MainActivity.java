package com.king.flagchrome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //declare var
    ListView mCountries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign view to variables
        mCountries = findViewById(R.id.list);
        //set an on-item click
        mCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent flags = new Intent(getApplicationContext(), flag_chrome_activity.class);
                flags.putExtra("pos", position);
                startActivity(flags);
            }
        });
    }
}
