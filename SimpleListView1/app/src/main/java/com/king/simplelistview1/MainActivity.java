package com.king.simplelistview1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declare variables
    ListView mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign
        mList = findViewById(R.id.listview);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "you are ordering a" +getResources()
                        .getStringArray(R.array.movies)[position], Toast.LENGTH_SHORT).show();

                if (position == 0){
                    Intent openActivitySecond = new Intent(getApplicationContext(),Simple_List_activity.class);
                    startActivity(openActivitySecond);
                }
            }
        });



    }
}
