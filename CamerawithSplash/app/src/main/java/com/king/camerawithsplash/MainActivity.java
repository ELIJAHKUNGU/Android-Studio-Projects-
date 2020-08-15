package com.king.camerawithsplash;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //declare var
    ImageView mPic;
    Button mTakePicBtn;

    //camera requerst code
    final  int REQ =760;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ASSIGN
        mPic = findViewById(R.id.imageView);
        mTakePicBtn = findViewById(R.id.btncam);
   //set click handle on btn
     mTakePicBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent LaunchCam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
             startActivityForResult(LaunchCam, REQ);
         }
     });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       if (requestCode== REQ && resultCode == Activity.RESULT_OK) {
           Bitmap photo = (Bitmap) data.getExtras().get("data");
           mPic.setImageBitmap(photo);
       }
    }
}
