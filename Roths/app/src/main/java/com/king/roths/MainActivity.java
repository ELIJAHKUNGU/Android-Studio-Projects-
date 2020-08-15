package com.king.roths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //type varaName;
    //declare variables to hold your views items
    Button mToastBtn;
    EditText mUserInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign variables to respective views
        mToastBtn = findViewById(R.id.btnToast);
        mUserInput = findViewById(R.id.editText2);

        mToastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logic to be executed once button clicked
                //get user input
                String username = mUserInput.getText().toString();
                //create a toast notification
                Toast.makeText(MainActivity.this, "Hi there" + username + "Do have a great day", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
