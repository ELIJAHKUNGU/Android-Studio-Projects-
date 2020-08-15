package com.king.spinner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declare var
    Spinner mSpinner;
    Button mToastSpinnerValues;
    RelativeLayout layout;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = findViewById(R.id.btnToastSpinnerValue);
        mToastSpinnerValues = findViewById(R.id.button);
        layout = findViewById(R.id.relative);
        //array adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.cars,
                android.R.layout.simple_spinner_item
        );
        //layout style
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //load data from adapter
        mSpinner.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate your menu
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.pic:
                Intent cam  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cam, 001);
                break;
            case R.id.red:
                layout.setBackgroundColor(Color.RED);
                break;
            case R.id.set:
                layout.setBackgroundColor(Color.LTGRAY);
                break;

        }


        return super.onOptionsItemSelected(item);
    }

    public void ToastSpinnerValues(View view) {
        Toast.makeText(this,mSpinner.getSelectedItem().toString() + "Selected", Toast.LENGTH_SHORT);
    }


}
