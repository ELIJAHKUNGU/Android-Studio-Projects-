package com.vibration.homedoctor.activities.models;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.vibration.homedoctor.HosiCat;
import com.vibration.homedoctor.HospitalActivity;
import com.vibration.homedoctor.PatientActivity;
import com.vibration.homedoctor.R;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);


/*
        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getSupportActionBar().hide();*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }






    public void registerUser(View view) {
        startActivity(new Intent(CategoriesActivity.this, PatientActivity.class));
    }



    public void Btnnew(View view) {
        startActivity(new Intent(CategoriesActivity.this, DetailsHospitalActivity.class));
    }

    public void btnNewUser(View view) {
        startActivity(new Intent(CategoriesActivity.this, HospitalActivity.class));
    }

    public void HosipitalActivity(View view) {
        startActivity(new Intent(CategoriesActivity.this, HosiCat.class));
    }
}
