package com.king.simplelistview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Simple_List_activity extends AppCompatActivity {
    //declare var
    ListView mSecondList;

    //define sting array
    String[] stars = {"jordan","archie","veronica","jughead","jellybean","beth","piko","bigsum"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple__list_activity);

        //assing
        mSecondList = findViewById(R.id.listview);

        //simple adapter to tell listview about data to display
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,stars);

        mSecondList.setAdapter(adapter);
    }
}
