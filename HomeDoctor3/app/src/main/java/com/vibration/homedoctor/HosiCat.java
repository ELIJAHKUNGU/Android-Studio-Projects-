package com.vibration.homedoctor;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.vibration.homedoctor.activities.models.DetailsHospitalActivity;

public class HosiCat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosi_cat);
        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getSupportActionBar().hide();
    }

    public void btnNewUser(View view) {
        startActivity(new Intent(HosiCat.this, DetailsHospitalActivity.class));
    }

    public void BtnExsting(View view) {
        startActivity(new Intent(HosiCat.this, HospitalActivity.class));

    }


    public void PhoneNumber(View view) {
        Intent showCallLog = new Intent();
        showCallLog.setAction(Intent.ACTION_VIEW);
        showCallLog.setType(CallLog.Calls.CONTENT_TYPE);
        startActivity(showCallLog);

    }

   /* public void Search(MenuItem item) {











    }*/
}
