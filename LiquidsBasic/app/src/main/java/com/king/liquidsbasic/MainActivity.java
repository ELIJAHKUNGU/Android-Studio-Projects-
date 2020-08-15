package com.king.liquidsbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declare variable to hold
    //syntax Type varName
    Button mToastBtn, mCountupBtn, mCountDownBtn;
    TextView mDispalyCount;

    //strings array
    String[] greetings = {"Handsome","Beutifull","PrettyFace","PengTing","Lovely","Caring","Kind",
    };

    int indexPos= 0;
    int mCount =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign variables to their respective views
        mToastBtn = findViewById(R.id.btnToast);
        mCountupBtn = findViewById(R.id.btnCountup);
        mCountDownBtn = findViewById(R.id.btnCountdown);
        mDispalyCount = findViewById(R.id.txtdisplay);

        //on click listener
        //programatically
        mToastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logic
                Toast.makeText(MainActivity.this, "hey there" + greetings[indexPos], Toast.LENGTH_SHORT).show();
                if (indexPos < greetings.length){
                    indexPos++;
                }else{
                    indexPos = 0;
                }

            }
        });

    }

    }



